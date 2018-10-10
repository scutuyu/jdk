package com.tuyu.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author tuyu
 * @date 10/8/18
 * Talk is cheap, show me the code.
 */
public class Md5 {

    public static final String md5Encode16(String string){
        String s = md5Encode32(string);
        return s == null ? s : s.substring(8, 24);
    }

    public static final String md5Encode32(String string) {
        try {
            byte[] bytes = MessageDigest.getInstance("md5").digest(string.getBytes("utf-8"));
            int curr = 0;
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                if ((curr = bytes[i]) < 0) {
                    curr += 256;
                }
                if (curr < 16) {
                    buffer.append(0);
                }
                buffer.append(Integer.toHexString(curr));
            }
            return buffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
