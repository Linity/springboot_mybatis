package com.ljw.web.utils;

import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Linity on 2017/4/26.
 */
public class CheckUtil {
    private static final String TOKEN="weixin";
    public static Boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr = new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(arr);
        StringBuffer content = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            content.append(arr[i]);
        }
        String temp = getSHA1String(content.toString());
        return temp.equals(signature);
    }
    private static String getSHA1String(String data){
        return DigestUtils.sha1Hex(data);    // 使用commons codec生成sha1字符串
    }
}
