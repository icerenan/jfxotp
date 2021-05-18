package com.home.icerenan.otp.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BasicConfigFileUtils {
    private static File file = FileUtils.getFile(BasicConfigFileUtils.class.getClassLoader().getResource("config/basic.config.txt").getPath());
    public static void readBasicConfigContent() throws IOException {
        String content = FileUtils.readFileToString(file,"utf-8");
        if(StringUtils.isBlank(content)){
            return;
        }
        content = EncryptAndDencryptUtils.encryptAndDencrypt(content);
        if(StringUtils.isBlank(content)){
            return;
        }
        BasicConfigMapCacheUtils.getInstance().putAll(JSONObject.parseObject(content,Map.class));
    }
    public static void writeBasicConfigContent() throws IOException {
        if(BasicConfigMapCacheUtils.getInstance().size()<1){
            return;
        }
        String content = JSON.toJSON(BasicConfigMapCacheUtils.getInstance()).toString();
        if(StringUtils.isBlank(content)) {
            return;
        }
        FileUtils.writeStringToFile(file, EncryptAndDencryptUtils.encryptAndDencrypt(content), "utf-8");
    }
}