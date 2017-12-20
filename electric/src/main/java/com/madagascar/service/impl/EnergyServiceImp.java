package com.madagascar.service.impl;

import com.madagascar.dao.EnergyMapper;
import com.madagascar.model.Energy;
import com.madagascar.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public List<Energy> queryAll(Energy energy) {
        return null;
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
}
