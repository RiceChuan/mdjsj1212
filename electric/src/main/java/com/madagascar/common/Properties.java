package com.madagascar.common;

/**
 * @Creator future
 * @Date 02/09/2017 2:50 PM
 * @DESC #DESC#  请求头header常量
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 02/09/2017 2:50 PM
 * @LOG $log$
 */
public interface Properties {
    //会话记录id
    String KEY_AUTHORIZATION = "authorization";
    String KEY_UID = "uid";
    String KEY_SSO = "/sso";

//    //会话超时时间  单位秒
    int TIME_OVER=60*60;

    //压缩包上传地址  当前项目根目录
//    String TEMPFILE=System.getProperty("user.dir")+"\\tempfile\\";
    //放在c盘
    String TEMPFILE="C:\\tempfile\\";
    //压缩包解压后图片存放地址
//    String FILEPATH=System.getProperty("user.dir")+"\\pyrometerImg";
    String FILEPATH="C:\\pyrometerImg";
//保存图片和数据的最大时间，过期清除
  int File_EFFECTIVE_TIME = 60;
}
