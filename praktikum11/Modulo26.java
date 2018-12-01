/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum11;

/**
 *
 * @author Ardania
 */
public class Modulo26 {
    public static void main(String[] args) {
        String plainText="SISTER";
        String secretKey = "SECRETKEY";
        System.out.println("Plain Text before encryption"+ plainText);
        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("Encript Text after encription"+encryptedText);
        String decryptedText = decrypt(encryptedText,secretKey);
        System.out.println("Decript Text after decription"+decryptedText);
        
    }
    private static String encrypt ( String plainText, String secretKey){
        StringBuilder encryptedString = new StringBuilder();
        int encryptedInt;
        for (int i = 0; i < plainText.length(); i++){
            int plainTextInt = (int) (plainText.charAt(i)- 'A');
            int secretKeyInt = (int) (secretKey.charAt(i)- 'A');
            encryptedInt = (plainTextInt + secretKeyInt) % 26;
            encryptedString.append((char) ((encryptedInt) + (int) 'A'));
            
        }
        return encryptedString.toString();
    }
    private static String decrypt (String decryptedText, String secretKey){
        StringBuilder decryptedString = new StringBuilder();
        int decryptedInt;
        for (int i=0; i < decryptedText.length(); i++){
            int decryptedTextInt = (int) (decryptedText.charAt(i) - 'A');
            int secretKeyInt = (int) (secretKey.charAt(i)  - 'A');
            decryptedInt = decryptedTextInt - secretKeyInt;
            if (decryptedInt <0){
                decryptedInt += 26;
            }
            decryptedString.append((char) ((decryptedInt)+ (int) 'A'));
        }
        return decryptedString.toString();
}
}
