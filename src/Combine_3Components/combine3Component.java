package Combine_3Components;

import java.util.Scanner;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;



import Combine_3Components.KCV;

	public class combine3Component {


		public static void main(String[] args)  throws 
		 InvalidKeyException, NoSuchAlgorithmException, 
		 NoSuchPaddingException, BadPaddingException, 
		 IllegalBlockSizeException {
//			int CompCount;
			String keypart1;
			String keypart2;
			String keypart3;


	                System.out.println("--------------------------------------------------------");
	                System.out.println("    Bruce.lee     3 Component key Combine Tool    ");
	                System.out.println("--------------------------------------------------------");

			Scanner sc = new Scanner(System.in);
//			System.out.println("How many components?");
//			CompCount = sc.nextInt();
			System.out.println("Input Component 1");
			keypart1 = sc.next();
			int keysize1 = keypart1.length();

	                System.out.println("--------------------------------------------------------");
			System.out.println("Input Component 2");
			keypart2 = sc.next();
			int keysize2 = keypart2.length();

	                if((keysize1!=keysize2) || (keysize1 % 8 != 0) || (keysize2 % 8 != 0)) {
	                        System.out.println("!!!!!! ERROR : Invalid Key. Check data and Re-run !!!!!!");
	                System.out.println("--------------------------------------------------------");
	                        System.exit(999);
	                }

	                System.out.println("--------------------------------------------------------");
			System.out.println("Input Component 3");
			keypart3 = sc.next();
			int keysize3 = keypart3.length();
	                System.out.println("");
	                System.out.println("");

	                
	                if((keysize2!=keysize3) || (keysize3 % 8 != 0)) {
	                    System.out.println("!!!!!! ERROR : Invalid Key. Check data and Re-run !!!!!!");
	            System.out.println("--------------------------------------------------------");
	                    System.exit(999);
	            }

            String KCV1= KCV.AES(keypart1);
            String KCV2= KCV.AES(keypart2);
            String KCV3= KCV.AES(keypart3);

			
            System.out.println("----------------------------------------------------------------------------------------------------------------");
	                System.out.println("[INPUT DATA]");
			System.out.println("Component 1("+keypart1.length()+" HexString): "+keypart1+"   KCV(AES)  " +KCV1.substring(0,6));
			System.out.println("Component 2("+keypart2.length()+" HexString): "+keypart2+"   KCV(AES)  " +KCV2.substring(0,6));
			System.out.println("Component 3("+keypart3.length()+" HexString): "+keypart3+"   KCV(AES)  " +KCV3.substring(0,6));


			
			
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println("");

			byte[] Bkeypart1 = SC.hexStringToByteArray(keypart1);
			byte[] Bkeypart2 = SC.hexStringToByteArray(keypart2);
			byte[] Bkeypart3 = SC.hexStringToByteArray(keypart3);

//	                System.out.println(Bkeypart1);
//	                System.out.println(Bkeypart2);
//	                System.out.println(Bkeypart3);

			String B2Skeypart1 = SC.byteArrayToHexString(Bkeypart1);
			String B2Skeypart2 = SC.byteArrayToHexString(Bkeypart2);
			String B2Skeypart3 = SC.byteArrayToHexString(Bkeypart3);


			byte[] masterKey;
			
    	    masterKey = XOR.xor3key(Bkeypart1, Bkeypart2, Bkeypart3);

			String B2SmasterKey = SC.byteArrayToHexString(masterKey);

	        String KCV0= KCV.AES(B2SmasterKey);


            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println("Combined Key("+B2SmasterKey.length()+" HexString): "+B2SmasterKey+"   KCV(AES)  " +KCV0.substring(0,6));
            System.out.println("----------------------------------------------------------------------------------------------------------------");
			}
	


}
