package Combine_3Components;

public class SC {
	    
        public static byte[] hexStringToByteArray(String s) {
            int len = s.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                     + Character.digit(s.charAt(i+1), 16));
            }
            return data;
        }


        public static String byteArrayToHexString(byte[] bytes){

                StringBuilder sb = new StringBuilder();

                for(byte b : bytes){

                        sb.append(String.format("%02X", b&0xff));
                }

                return sb.toString();
        }
	    
	    
	    
	    

	    public static byte[] hexStringToByteArray2(String hex) {
	        int l = hex.length();
	        byte[] data = new byte[l/2];
	        for (int i = 0; i < l; i += 2) {
	            data[i/2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                                 + Character.digit(hex.charAt(i+1), 16));
	        }
	        return data;
	    }
	    
	    public static String hexToAscii(String hexStr) {
	        StringBuilder output = new StringBuilder("");
	         
	        for (int i = 0; i < hexStr.length(); i += 2) {
	            String str = hexStr.substring(i, i + 2);
	            output.append((char) Integer.parseInt(str, 16));
	        }
	         
	        return output.toString();
	    }
	
}
