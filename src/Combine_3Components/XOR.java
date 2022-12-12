package Combine_3Components;

public class XOR {
    public static byte[] xor2key(byte[] cc1, byte[] cc2) {
        byte[] result = new byte[cc1.length];
        int i = 0;
        for (byte b1: cc1) {
          byte b2 = cc2[i];
          result[i] = (byte)(b1 ^ b2);
          i++;
        }
        return result;
      }
    
    public static byte[] xor3key(byte[] cc1, byte[] cc2, byte[] cc3) {
        byte[] result = new byte[cc1.length];
        int i = 0;
        for (byte b1: cc1) {
          byte b2 = cc2[i];
          byte b3 = cc3[i];
          result[i] = (byte)(b1 ^ b2 ^ b3);
          i++;
        }
        return result;
      }

}
