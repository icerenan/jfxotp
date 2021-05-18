package com.home.icerenan.otp.utils;

import javafx.scene.layout.GridPane;

import java.util.concurrent.ConcurrentHashMap;

public class GridPandMapCacheUtils extends ConcurrentHashMap<String, GridPane> {
    private static volatile GridPandMapCacheUtils instance = null;
    private GridPandMapCacheUtils(){};
    public static GridPandMapCacheUtils getInstance() {
        if (instance == null) {
            instance = new GridPandMapCacheUtils();
        }
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new GridPandMapCacheUtils();
                }
            }
        }
        return instance ;
    }
}