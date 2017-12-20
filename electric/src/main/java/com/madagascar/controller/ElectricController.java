package com.madagascar.controller;


import com.madagascar.common.RestResult;
import com.madagascar.oauth.annotation.Authorization;
import com.madagascar.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by RiceChuan on 17.12.18.
 */
@Controller
@Slf4j
public class ElectricController {
    @RequestMapping("/electricByUserId")
    @ResponseBody
    @Authorization
    public RestResult electricByUserId(String date){
        System.out.println(date);
        List list =new ArrayList();
        for (int i=1;i<31;i++){
            list.add(i+"号");
        }
        List list1 =new ArrayList();
        for (int i=0;i<30;i++){
            int random = RandomUtil.random(1, 30);
            list1.add(random);
        }
        Map map = new HashMap();
        map.put("list",list);
        map.put("list1",list1);

        return RestResult.success(map);
    }
}
