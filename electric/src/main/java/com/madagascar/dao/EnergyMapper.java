package com.madagascar.dao;

import com.madagascar.model.Energy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 0 on 2017/12/19.
 */
@Mapper
public interface EnergyMapper {
    //插入一条数据
    void insertEnergy(Energy energy);
    //更新电量使用情况
    void updateEnergy(Energy energy);
    List<Energy> queryAll();
    Energy queryById(Energy energy);
}
