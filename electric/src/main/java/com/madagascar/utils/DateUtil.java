package com.madagascar.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Creator LC
 * @Date 2017/9/3 10:41
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 2017/9/3 10:41
 * @LOG $log$
 */
public class DateUtil {
    public static String dateToStr(Date date, String formatStr) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }
    public static Date strToDate(SimpleDateFormat sdf,String formatStr) {
        Date date=null;
        try {
             date = sdf.parse(formatStr);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("字符串异常");
        }
        return date;
    }
    public static long getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day;
    }
}
