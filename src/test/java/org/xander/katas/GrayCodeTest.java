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
    public void testBasic() {
        assertNotNull(grayCode);
    }

    @Test
    public void testBasicEncode() {
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

        byte[] encodedArray = new byte[5];
        encodedArray = grayCode.encode(originalArray);
        for (int i = 0; i < encodedArray.length; i++) {
            assertEquals(expectedResultArray[i], encodedArray[i]);

        }
    }
}
