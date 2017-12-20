package com.madagascar.utils;

import java.util.Random;

/**
 * Created by RiceChuan on 17.12.19.
 * 随机数工具
 */
public class RandomUtil {
    public static int random(int min,int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
}
