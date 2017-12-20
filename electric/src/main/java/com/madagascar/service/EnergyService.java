package com.madagascar.service;

import com.madagascar.model.Energy;

import java.util.List;

/**
 * Created by 0 on 2017/12/19.
 */
public interface EnergyService {
    String insertEnergy(Energy energy);
    String updateEnergy(Energy energy);
    List<Energy> queryAll(Energy energy);
    Energy queryById(Energy energy);
}
