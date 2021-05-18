package com.home.icerenan.otp.utils;

import java.util.concurrent.ConcurrentHashMap;

public class BasicConfigMapCacheUtils extends ConcurrentHashMap<String,String> {
    private static volatile  BasicConfigMapCacheUtils instance = null;
    private BasicConfigMapCacheUtils(){};
    public static BasicConfigMapCacheUtils getInstance() {
        if (instance == null) {
            instance = new BasicConfigMapCacheUtils();
        }
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new BasicConfigMapCacheUtils();
                }
            }
        }
        return instance ;
    }
}