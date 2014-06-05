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

    public byte[] decode(byte[] originalEncodedArray) {
        int arrayLength = originalEncodedArray.length;

        byte[] decodedArray = new byte[arrayLength];
        decodedArray[0] = originalEncodedArray[0];
        for (int i = 1; i < arrayLength; i++) {
            decodedArray[i] = (byte) (originalEncodedArray[i] ^ decodedArray[i - 1]);
        }
        return decodedArray;
    }
}
