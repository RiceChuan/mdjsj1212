package com.madagascar.utils;

import java.util.UUID;

/**
 * @Creator LC
 * @Date 2017/9/2 17:18
 * @DESC #DESC#
 * @VERSION 1.0
 * <p>
 * @Updator $AUTHOR$
 * @UpdateTime 2017/9/2 17:18
 * @LOG $log$
 */
public class UUIDUtils {
    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
