package com.madagascar.dao;

import com.madagascar.model.Token;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Creator future
 * @Date 02/09/2017 2:49 PM
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:49 PM
 * @LOG $log$
 */
@Mapper
public interface TokenMapper {
    Token findByToken(@Param("token") String token);

    int insert(Token token);

    /**
     * 根据用户id删除token
     * @param uid
     * @return
     */
    int deleteByUid(@Param("uid") String uid);

}
