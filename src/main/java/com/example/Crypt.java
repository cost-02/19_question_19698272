package com.example;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
//import org.apache.commons.codec.binary.Base64;

public class Crypt {
    public static String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    public static byte[] key_Array = Base64.decodeBase64(key);
    public static byte[] iv_Array = new byte[16]; // IV casuale o fisso sicuro

    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec SecretKey = new SecretKeySpec(key_Array, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv_Array);
            Cipher _Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            _Cipher.init(Cipher.ENCRYPT_MODE, SecretKey, ivSpec);
            return Base64.encodeBase64String(_Cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("[Exception]:"+e.getMessage());
        }
        return null;
    }
}