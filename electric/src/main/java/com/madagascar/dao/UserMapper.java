package com.madagascar.dao;

import com.madagascar.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


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
}
