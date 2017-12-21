package com.madagascar.dao;

import com.madagascar.model.AppUser;
import com.madagascar.model.User;
import com.madagascar.model.UserLogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @Creator future
 * @Date 02/09/2017 2:58 PM
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:58 PM
 * @LOG $log$
 */
@Mapper
public interface UserMapper {
    User queryById(String uid);
    //测试用
    User findByUserNameAndPwd(@Param("username") String username, @Param("password") String password);
   //再次测试用
    void test();

    int searchUserDataNumber();
}
