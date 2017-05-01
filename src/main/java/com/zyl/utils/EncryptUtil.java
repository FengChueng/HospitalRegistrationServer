package com.zyl.utils;


/**
 * 加密工具类
 * Created by cjb
 */


public class EncryptUtil {
    /**
     * 对用户密码进行加密处理
     * @param userPassword
     * @return
     */
    public static String encryptUserPassword(String userPassword){
        return CommUtils.bytesConvertToHexString(MD5.getMD5(userPassword.getBytes()));
    }
}
