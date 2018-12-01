/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum11;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Ardania
 */
public class Crypto {
     private static Cipher cipher = null;
    public static void main(String[] args) throws Exception{
        KeyGenerator keygenerator = KeyGenerator.getInstance("DESede");
        keygenerator.init(168);
        SecretKey secretKey = keygenerator.generateKey();
        cipher = Cipher.getInstance("DESede");
        
        String plainText= " Kriptografy menggunakan java Cryptography Extension";
        System.out.println("Plain Text before Cryptografy: "+plainText);
        
        byte[] plainTextByte = plainText.getBytes("UTF8");
        byte[] encryptedByte = encrypt(plainTextByte, secretKey);
        
        String encryptedText = new String (encryptedByte, "UTF8");
        System.out.println("Encrypted Text After Encryption"+ encryptedText);
        
        byte[] decryptedByte = decrypt(encryptedByte,secretKey);
        String decryptedText = new String (decryptedByte, "UTF8");
        System.out.println("Decrypted Text After Decryption: "+decryptedText);
        
    }
    static byte[] encrypt(byte[] plainTextByte,SecretKey secretKey) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        return encryptedByte;
    }
    static byte[] decrypt(byte[] encryptedbyte, SecretKey secretKey) throws Exception{
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedbyte);
        return decryptedByte;
}
}
