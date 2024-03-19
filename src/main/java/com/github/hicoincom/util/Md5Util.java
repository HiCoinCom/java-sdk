package com.github.hicoincom.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ChainUp Custody
 */
public class Md5Util {

    public static String getMd5(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(info.getBytes(StandardCharsets.UTF_8));

            byte[] md5Array = md5.digest();

            return bytesToHex(md5Array);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static String bytesToHex(byte[] md5Array) {
        StringBuilder strBuilder = new StringBuilder();
        for (byte b : md5Array) {
            int temp = 0xff & b;
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {
                strBuilder.append("0").append(hexString);
            } else {
                strBuilder.append(hexString);
            }
        }
        return strBuilder.toString();
    }
}
