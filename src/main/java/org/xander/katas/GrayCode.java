package org.xander.katas;

public class GrayCode {
    public byte[] encode(byte[] originalArray) {
        int arrayLength = originalArray.length;
        byte[] encodedArray = new byte[arrayLength];

        for (int i = 1; i < arrayLength; i++) {
            encodedArray[i] = originalArray[i - 1];
        }
        encodedArray[0] = originalArray[arrayLength - 1];

        byte[] resultArray = new byte[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            resultArray[i] = (byte) (encodedArray[i] ^ originalArray[i]);
        }
        return resultArray;
    }
}
