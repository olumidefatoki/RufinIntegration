/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.tempuri.ITransactionGate;
import org.tempuri.SmartMicroTransactionGate;


/**
 *
 * @author olumidefatoki
 */

public class Encryptor {
    private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String aesEncryptionAlgorithm = "AES";
    
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        //TODO code application logic here
       // String encrypt = encrypt("12334343");
       // System.out.println("encrypt " + encrypt);
       
      //System.out.println("hexStringToByteArray " + hexStringToByteArray);
      SmartMicroTransactionGate gate  = new SmartMicroTransactionGate();
      ITransactionGate ITrans = gate.getBasicHttpBindingITransactionGate();
        String referenceId = encrypt("100338766688","YmE4ZTQxMDBmYTM3");
        System.out.println("RefID " + referenceId);
      String fTransferDB = ITrans.fundTransferAccountDebit("1510000004", "YmE4ZTQxMDBmYTM3", "100338766688", "08067145722", "001", "2", "1000", "50", referenceId, 2);
      System.out.println("Result " + fTransferDB);
    }
 

    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    

    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
        byte[] keyBytes = new byte[16];
        byte[] parameterKeyBytes = key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }
     private static byte[] encrypt(byte[] plainText, byte[] key, byte[] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, aesEncryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        try{
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return plainText;
    }
     

    
     public static String encrypt(String plainText, String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes = getKeyBytes(key);
        String encoded = Base64.getEncoder().encodeToString(encrypt(plainTextbytes, keyBytes, keyBytes));
        return encoded;
    } 

}


