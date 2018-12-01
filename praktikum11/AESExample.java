/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum11;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Ardania
 */
public class AESExample {
    static Cipher cipher;
    public static void main(String[] args)  throws Exception{
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        keygenerator.init(128);
        SecretKey secretKey = keygenerator.generateKey();
        cipher = Cipher.getInstance("AES");
        
        String plainText = "AES Symmetric Encryption Decryption";
        System.out.println("PlainText  Before Encryption : "+plainText);
        
        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("Encrypted Text After Encryption : "+encryptedText);
        
        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text After Decription "+ decryptedText);
    }
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception{
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception{
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
       cipher.init(Cipher.DECRYPT_MODE, secretKey);
       byte[] decyptedByte = cipher.doFinal(encryptedTextByte);
       String decryptedText = new String (decyptedByte);
       return decryptedText;
}
}
