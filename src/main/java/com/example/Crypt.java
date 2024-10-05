package com.example;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class Crypt {
    public static String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // La chiave deve essere di lunghezza adeguata
    public static byte[] key_Array = Base64.getDecoder().decode(key);
    public static byte[] iv_Array = new byte[16]; // IV casuale o fisso sicuro

    public static String encrypt(String strToEncrypt) {
        try {
            SecretKeySpec SecretKey = new SecretKeySpec(key_Array, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv_Array);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, SecretKey, ivSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("[Exception]:" + e.getMessage());
        }
        return null;
    }
}
