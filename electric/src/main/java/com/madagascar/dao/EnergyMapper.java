package com.madagascar.dao;

import com.madagascar.model.Energy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    //根据用户id查询用户日用电情况
    List<Energy> queryAll(@Param("user_id")int user_id);
    Energy queryById(Energy energy);
    //根据用户id 查看同一天 是否已经创建了新数据
    Energy queryByUserID(Energy energy);
}
