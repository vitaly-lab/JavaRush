package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        int a = ip[0] & mask[0];
        int b = ip[1] & mask[1];
        int c = ip[2] & mask[2];
        int d = ip[3] & mask[3];

      byte net[] = new byte[4];

      net[0] = (byte) a;
      net[1] = (byte) b;
      net[2] = (byte) c;
      net[3] = (byte) d;

      // return new byte[4];
        return net;

    }

    public static void print(byte[] bytes) {

   //     byte a1 = bytes[0];

     //   String a = Integer.toBinaryString(bytes[0]);
       // String b = Integer.toBinaryString(bytes[1]);
      //  String c = Integer.toBinaryString(bytes[2]);
      //  String d = Integer.toBinaryString(bytes[3]);

      //  System.out.println(a + " " + b + " " + c + " " + d);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(String.format("%8s", Integer.toBinaryString((bytes[i]) & 0xFF)).replace(' ', '0') + " ");
        }

    }
}
