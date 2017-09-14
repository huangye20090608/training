package com.huangye.training.demo.basic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by huangye on 2017/6/23.
 */
public class PAYMD5 {
    public static String getMD5Code(String str) throws UnsupportedEncodingException {
        byte unencoded[] = str.getBytes("GBK");
        MessageDigest md5 = null;
        try
        {
            md5 = MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        md5.update(unencoded);
        byte encoded[] = md5.digest();
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < encoded.length; i++)
        {
            if((encoded[i] & 255) < 16)
                buf.append("0");
            buf.append(Long.toString(encoded[i] & 255, 16));
        }

        return buf.toString().toUpperCase();
    }
}
