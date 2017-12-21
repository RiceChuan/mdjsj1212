package com.madagascar.controller;

import com.madagascar.common.RestResult;
import com.madagascar.dto.EnergyRequest;
import com.madagascar.model.Energy;
import com.madagascar.oauth.annotation.Authorization;
import com.madagascar.service.EnergyService;
import com.madagascar.utils.RandomUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 0 on 2017/12/19.
 * 日用量
 */
@RestController
public class EnergyControl {
    @Autowired
    EnergyService energyService;
    @PostMapping(value = "/energy_operate" ,produces = "application/json;charset=UTF-8")
    public Object energy_operate(@RequestBody EnergyRequest request){
        String code = request.getCode();

        Energy energy = new Energy();
        double use_power = 0.00;
        if(code.equals("1")){
            //插入操作
            energy.setId(request.getId());
            energy.setUser_id(request.getUser_id());
            energy.setUse_power(request.getUse_power());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            energy.setUse_date(simpleDateFormat.format(new Date()));
           return energyService.insertEnergy(energy);
        }else if(code.equals("2")){
            //更新操作
            energy.setId(request.getId());
            Energy energy1 = energyService.queryById(energy);//根据ID查询当前的使用电量
            use_power = energy1.getUse_power()+ request.getUse_power();//电量自增
            energy.setUse_power((double) Math.round(use_power*100000)/100000);
            return energyService.updateEnergy(energy);
        }else if(code.equals("3")){
            //查询是否存在同一天的数据
            energy.setUser_id(request.getUser_id());
            return  energyService.queryByUserID(energy);
        }
        return null;
    }

    //刘川的查询日用表数据库demo
    @RequestMapping("/electricByUserId")
    @ResponseBody
    @Authorization
    public RestResult electricByUserId(String date){
        List<Energy> list1 = energyService.queryAll("6");
        System.out.println(date);
        List list =new ArrayList();
        for (int i=1;i<list1.size();i++){
            list.add(i+"号");
        }

        List list2 =new ArrayList();
        for (int i=0;i<list1.size();i++){
            list2.add(list1.get(i).getUse_power());
        }
        Map map = new HashMap();
        map.put("list",list);
        map.put("list1",list2);

        return RestResult.success(map);
    }

}
