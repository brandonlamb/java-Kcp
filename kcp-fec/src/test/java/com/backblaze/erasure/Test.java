package com.backblaze.erasure;

/**
 * Created by JinMiao
 * 2019-08-13.
 */
public class Test {
    public static void main(String[] args) {
        int datashard = 5;
        int parityshard = 3;
        int totalshard = datashard + parityshard;
        ReedSolomon reedSolomon = ReedSolomon.create(datashard,parityshard);

        byte[][] bytesres = {
                {(byte) 232,19, (byte) 158,},
                {38, (byte) 175, (byte) 197,},
                {114,68, (byte) 188,},
                {109,120,80,},
                {102,47,102,},
                {0,0,0,},
                {0,0,0,},
                {0,0,0,},};

        reedSolomon.encodeParity(bytesres,0,3);

        for (int i = 0; i < bytesres.length; i++) {
            byte[] bytes = bytesres[i];
            for (byte aByte : bytes) {
                int result = aByte&0xff;
                System.out.print(result+",");
            }
            System.out.println();
        }

        System.out.println();
    }
}
