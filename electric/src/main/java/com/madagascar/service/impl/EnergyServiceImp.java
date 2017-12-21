package com.madagascar.service.impl;

import com.madagascar.dao.EnergyMapper;
import com.madagascar.model.Energy;
import com.madagascar.service.EnergyService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 0 on 2017/12/19.
 */
@Component
public class EnergyServiceImp implements EnergyService {
    @Autowired
    EnergyMapper energyMapper;
    @Override
    public String insertEnergy(Energy energy) {
        try {
            energyMapper.insertEnergy(energy);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public String updateEnergy(Energy energy) {
        try {
            energyMapper.updateEnergy(energy);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public List<Energy> queryAll(String id) {
        List<Energy> list = energyMapper.queryAll(id);
        return list;
    }

    @Override
    public Energy queryById(Energy energy) {
        try {
            Energy energy1 = energyMapper.queryById(energy);
            return energy1;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String queryByUserID(Energy energy) {
        try {
            Energy energy1 = energyMapper.queryByUserID(energy);
            Date currentTime = new Date();//当前时间
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar rightNow =   Calendar.getInstance();//当前时间
            Date dayOne = rightNow.getTime();
           Date date =  dateFormat.parse(energy1.getUse_date());


            if(null == energy1){//未查询到匹配数据
                return "no_data";
            }else {
                //比较两个时间是否为同一天 假如是同一天 则返回这张表的主键 用于后面更新数据用。
                if(DateUtils.isSameDay(dayOne,date)){
                    return energy1.getId();
                }else {//查询到了数据 但是不是同一天的  则后面是要执行插入数据操作的。
                    return "not_one_day";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
