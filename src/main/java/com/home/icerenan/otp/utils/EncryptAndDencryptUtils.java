package com.home.icerenan.otp.utils;

import com.home.icerenan.otp.constant.GlobalConstant;
import org.apache.commons.lang3.StringUtils;

public class EncryptAndDencryptUtils {
    public static String encryptAndDencrypt(String value){
        if(StringUtils.isBlank(value)){
            return value;
        }
        //将需要加密的内容转换为字节数组
        byte[] bt=value.getBytes();
        for(int i=0;i<bt.length;i++) {
            //通过异或运算进行加密
            bt[i]=(byte)(bt[i]^(int) GlobalConstant.SECRET);
        }
        //将加密后的字符串保存到 newresult 变量中
        String newresult=new String(bt,0,bt.length);
        return newresult;
    }
}