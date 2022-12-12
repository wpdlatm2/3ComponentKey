package Combine_3Components;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import Combine_3Components.SC;

public class KCV {

	public static String AES(String HexKey)  throws 
	 NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,  IllegalBlockSizeException
   {    	
       //	String strToEncrypt = "000";
       	
      //     byte[] iv = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
           byte[] iv = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  };


   		byte[] bytekey = new byte[HexKey.length() / 2];
   		
   		for (int i = 0; i < bytekey.length; i++) {
   			   int index = i * 2;
   			   int j = Integer.parseInt(HexKey.substring(index, index + 2), 16);
   			   bytekey[i] = (byte) j;
   			}

//   		SecretKeySpec key = new SecretKeySpec(smykey.getBytes(), "AES");
   		SecretKeySpec key = new SecretKeySpec(bytekey, "AES");


   		Cipher cipher =  Cipher.getInstance("AES/ECB/NoPadding");//("AES/ECB/PKCS7Padding");//("ECB");//("AES");
   		cipher.init(Cipher.ENCRYPT_MODE, key);

 //  		byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
   		byte[] encrypted = cipher.doFinal(iv);

   		
   		String Result = SC.byteArrayToHexString(encrypted);
   		return Result;
     
   }
	
}
