package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GrayCodeTest {
    GrayCode grayCode;

    @Before
    public void setUp() {
        grayCode = new GrayCode();
    }

    @Test
    public void basic() {
        assertNotNull(grayCode);
    }

    @Test
    public void basicEncode() {
        byte[] originalArray = new byte[5];
        originalArray[0] = 0;
        originalArray[1] = 1;
        originalArray[2] = 1;
        originalArray[3] = 0;
        originalArray[4] = 0;

        byte[] expectedResultArray = new byte[5];
        expectedResultArray[0] = 0;
        expectedResultArray[1] = 1;
        expectedResultArray[2] = 0;
        expectedResultArray[3] = 1;
        expectedResultArray[4] = 0;

        byte[] encodedArray = grayCode.encode(originalArray);
        for (int i = 0; i < encodedArray.length; i++) {
            assertEquals(expectedResultArray[i], encodedArray[i]);
        }
    }

    @Test
    public void basicDecode() {
        byte[] originalArray = new byte[5];
        originalArray[0] = 0;
        originalArray[1] = 1;
        originalArray[2] = 0;
        originalArray[3] = 1;
        originalArray[4] = 0;

        byte[] expectedResultArray = new byte[5];
        expectedResultArray[0] = 0;
        expectedResultArray[1] = 1;
        expectedResultArray[2] = 1;
        expectedResultArray[3] = 0;
        expectedResultArray[4] = 0;

        byte[] encodedArray = grayCode.decode(originalArray);
        for (int i = 0; i < encodedArray.length; i++) {
            assertEquals(expectedResultArray[i], encodedArray[i]);
        }
    }

    @Test
    public void basicEncodeAnotherOne() {
        byte[] originalArray = new byte[5];
        originalArray[0] = 1;
        originalArray[1] = 0;
        originalArray[2] = 1;
        originalArray[3] = 1;
        originalArray[4] = 0;

        byte[] expectedResultArray = new byte[5];
        expectedResultArray[0] = 1;
        expectedResultArray[1] = 1;
        expectedResultArray[2] = 1;
        expectedResultArray[3] = 0;
        expectedResultArray[4] = 1;

        byte[] encodedArray = grayCode.encode(originalArray);
        for (int i = 0; i < encodedArray.length; i++) {
            assertEquals(expectedResultArray[i], encodedArray[i]);
        }
    }

    @Test
    public void basicDecodeAnotherOne() {
        byte[] originalArray = new byte[5];
        originalArray[0] = 1;
        originalArray[1] = 1;
        originalArray[2] = 1;
        originalArray[3] = 0;
        originalArray[4] = 1;

        byte[] expectedResultArray = new byte[5];
        expectedResultArray[0] = 1;
        expectedResultArray[1] = 0;
        expectedResultArray[2] = 1;
        expectedResultArray[3] = 1;
        expectedResultArray[4] = 0;

        byte[] encodedArray = grayCode.decode(originalArray);
        for (int i = 0; i < encodedArray.length; i++) {
            assertEquals(expectedResultArray[i], encodedArray[i]);
        }
    }
}
