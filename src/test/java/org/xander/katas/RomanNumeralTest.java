package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class RomanNumeralTest {
    RomanNumeral romanNumeral;
    final static String ABSENT_NUMBER = "there is no such a number";

    @Before
    public void setUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void romanNumeral() {
        assertNotNull(romanNumeral);
    }

    @Test
    public void nothing() {
        String nothing = romanNumeral.convert();
        assertEquals("nothing was sent to convert", nothing);
    }

    @Test
    public void oneDigit() {
        String one = "1";
        String oneRoman = romanNumeral.convertOneDigit(one);
        assertEquals("I", oneRoman);

        String two = "2";
        String twoRoman = romanNumeral.convertOneDigit(two);
        assertEquals("II", twoRoman);

        String three = "3";
        String threeRoman = romanNumeral.convertOneDigit(three);
        assertEquals("III", threeRoman);

        String four = "4";
        String fourRoman = romanNumeral.convertOneDigit(four);
        assertEquals("IV", fourRoman);

        String five = "5";
        String fiveRoman = romanNumeral.convertOneDigit(five);
        assertEquals("V", fiveRoman);

        String six = "6";
        String sixRoman = romanNumeral.convertOneDigit(six);
        assertEquals("VI", sixRoman);

        String seven = "7";
        String sevenRoman = romanNumeral.convertOneDigit(seven);
        assertEquals("VII", sevenRoman);

        String eight = "8";
        String eightRoman = romanNumeral.convertOneDigit(eight);
        assertEquals("VIII", eightRoman);

        String nine = "9";
        String nineRoman = romanNumeral.convertOneDigit(nine);
        assertEquals("IX", nineRoman);
    }

    @Test
    public void twoDigit() {
        String ten = "10";
        String tenRoman = romanNumeral.convertTwoDigit(ten);
        assertEquals("X", tenRoman);

        String twenty = "20";
        String twentyRoman = romanNumeral.convertTwoDigit(twenty);
        assertEquals("XX", twentyRoman);

        String thirty = "30";
        String thirtyRoman = romanNumeral.convertTwoDigit(thirty);
        assertEquals("XXX", thirtyRoman);

        String forty = "40";
        String fortyRoman = romanNumeral.convertTwoDigit(forty);
        assertEquals("XL", fortyRoman);

        String fifty = "50";
        String fiftyRoman = romanNumeral.convertTwoDigit(fifty);
        assertEquals("L", fiftyRoman);

        String sixty = "60";
        String sixtyRoman = romanNumeral.convertTwoDigit(sixty);
        assertEquals("LX", sixtyRoman);

        String seventy = "70";
        String seventyRoman = romanNumeral.convertTwoDigit(seventy);
        assertEquals("LXX", seventyRoman);

        String eighty = "80";
        String eightyRoman = romanNumeral.convertTwoDigit(eighty);
        assertEquals("LXXX", eightyRoman);

        String ninety = "90";
        String ninetyRoman = romanNumeral.convertTwoDigit(ninety);
        assertEquals("XC", ninetyRoman);
    }

    @Test
    public void threeDigit() {
        String hundred = "100";
        String hundredRoman = romanNumeral.convertThreeDigit(hundred);
            assertEquals("C", hundredRoman);

        String twoHundred = "200";
        String twoHundredRoman = romanNumeral.convertThreeDigit(twoHundred);
        assertEquals("CC", twoHundredRoman);

        String threeHundred = "300";
        String threeHundredRoman = romanNumeral.convertThreeDigit(threeHundred);
        assertEquals("CCC", threeHundredRoman);

        String fourHundred = "400";
        String fourHundredRoman = romanNumeral.convertThreeDigit(fourHundred);
        assertEquals("CD", fourHundredRoman);

        String fiveHundred = "500";
        String fiveHundredRoman = romanNumeral.convertThreeDigit(fiveHundred);
        assertEquals("D", fiveHundredRoman);

        String sixHundred = "600";
        String sixHundredRoman = romanNumeral.convertThreeDigit(sixHundred);
        assertEquals("DC", sixHundredRoman);

        String sevenHundred = "700";
        String sevenHundredRoman = romanNumeral.convertThreeDigit(sevenHundred);
        assertEquals("DCC", sevenHundredRoman);

        String eightHundred = "800";
        String eightHundredRoman = romanNumeral.convertThreeDigit(eightHundred);
        assertEquals("DCCC", eightHundredRoman);

        String nineHundred = "900";
        String nineHundredRoman = romanNumeral.convertThreeDigit(nineHundred);
        assertEquals("CM", nineHundredRoman);
    }

    @Test
    public void fourDigit() {
        String thousand = "1000";
        String thousandRoman = romanNumeral.convertFourDigit(thousand);
        assertEquals("M", thousandRoman);
    }

    @Test
    public void absentCustomDigit() {
        assertEquals("there is no such a number", romanNumeral.convertCustomDigit(null));
    }

    @Test
    public void absentCustomOneDigit() {
        assertEquals("there is no such a number", romanNumeral.convertOneDigit(null));
    }

    @Test
    public void absentCustomTwoDigit() {
        assertEquals("there is no such a number", romanNumeral.convertTwoDigit(null));
    }

    @Test
    public void absentCustomThreeDigit() {
        assertEquals("there is no such a number", romanNumeral.convertThreeDigit(null));
    }

    @Test
    public void absentCustomFourDigit() {
        assertEquals("there is no such a number", romanNumeral.convertFourDigit(null));
    }

    @Test
    public void negative() {
        for (int i = 65; i < 91; i++) {
            String asciiToVerify = String.valueOf((char) i);
            String numberRoman = romanNumeral.convertFourDigit(asciiToVerify);
            assertEquals(ABSENT_NUMBER, numberRoman);
        }

        for (int i = 97; i < 123; i++) {
            String asciiToVerify = String.valueOf((char) i);
            String numberRoman = romanNumeral.convertFourDigit(asciiToVerify);
            assertEquals(ABSENT_NUMBER, numberRoman);
        }
    }

    @Test
    public void zeroTest() {
        String zero = "0";
        String zeroRoman = romanNumeral.convertOneDigit(zero);
        assertEquals(ABSENT_NUMBER, zeroRoman);
    }

    @Test
    public void nullValue() {
        String nullRoman = romanNumeral.convertFourDigit(null);
        assertEquals(ABSENT_NUMBER, nullRoman);
    }

    @Test
    public void wrongSizeOfDigits() {
        String oneSizeDigit = "1";
        String twoSizeDigit = "19";
        String threeSizeDigit = "432";
        String fourSizeDigit = "5121";

        String wrongNumberRoman11 = romanNumeral.convertTwoDigit(oneSizeDigit);
        String wrongNumberRoman111 = romanNumeral.convertThreeDigit(oneSizeDigit);
        String wrongNumberRoman1111 = romanNumeral.convertFourDigit(oneSizeDigit);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman11);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman111);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman1111);

        String wrongNumberRoman2 = romanNumeral.convertOneDigit(twoSizeDigit);
        String wrongNumberRoman222 = romanNumeral.convertThreeDigit(twoSizeDigit);
        String wrongNumberRoman2222 = romanNumeral.convertFourDigit(twoSizeDigit);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman2);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman222);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman2222);

        String wrongNumberRoman3 = romanNumeral.convertOneDigit(threeSizeDigit);
        String wrongNumberRoman33 = romanNumeral.convertTwoDigit(threeSizeDigit);
        String wrongNumberRoman3333 = romanNumeral.convertThreeDigit(threeSizeDigit);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman3);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman33);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman3333);

        String wrongNumberRoman4 = romanNumeral.convertThreeDigit(fourSizeDigit);
        String wrongNumberRoman44 = romanNumeral.convertThreeDigit(fourSizeDigit);
        String wrongNumberRoman444 = romanNumeral.convertThreeDigit(fourSizeDigit);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman4);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman44);
        assertEquals(ABSENT_NUMBER, wrongNumberRoman444);
    }

    @Test
    public void convertCustomFourDigitNumber() {
        String customDigit = "3888";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMDCCCLXXXVIII", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit3001Number() {
        String customDigit = "3001";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMI", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit1001Number() {
        String customDigit = "1001";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MI", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit3100Number() {
        String customDigit = "3100";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMC", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit3070Number() {
        String customDigit = "3070";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMLXX", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit9482Number() {
        String customDigit = "9482";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMMMMMMMCDLXXXII", customNumberRoman);
    }

    @Test
    public void convertCustomFourDigit3700Number() {
        String customDigit = "3700";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("MMMDCC", customNumberRoman);
    }

    @Test
    public void convertCustomThreeDigitNumber() {
        String customDigit = "388";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("CCCLXXXVIII", customNumberRoman);
    }

    @Test
    public void convertCustomThreeDigit800Number() {
        String customDigit = "800";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("DCCC", customNumberRoman);
    }

    @Test
    public void convertCustomThreeDigit801Number() {
        String customDigit = "801";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("DCCCI", customNumberRoman);
    }

    @Test
    public void convertCustomTwoDigit80Number() {
        String customDigit   = "80";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("LXXX", customNumberRoman);
    }

    @Test
    public void convertCustomTwoDigit10Number() {
        String customDigit = "10";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("X", customNumberRoman);
    }

    @Test
    public void convertCustomTwoDigit81Number() {
        String customDigit = "81";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("LXXXI", customNumberRoman);
    }

    @Test
    public void convertCustomTwoDigitNumber() {
        String customDigit = "38";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("XXXVIII", customNumberRoman);
    }

    @Test
    public void convertCustomOneDigitNumber() {
        String customDigit = "8";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals("VIII", customNumberRoman);
    }

    @Test
    public void convertCustomBigDigitNumber() {
        String customDigit = "1231231239";
        String customNumberRoman = romanNumeral.convertCustomDigit(customDigit);
        assertEquals(ABSENT_NUMBER, customNumberRoman);
    }

    @Test
    public void negativeWhetherAllNumbersUpTo10000AreExisting() {
        File fileWithRomanNumbers = new File("fileWithRomanNumbers");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileWithRomanNumbers, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int writtenLines = 1;
        try {
            for (int i = 1; i < 10000; i++) {
                String romanNumber = romanNumeral.convertCustomDigit(String.valueOf(i));

                writer.println(romanNumber);
                assertNotSame(ABSENT_NUMBER, romanNumber);
                writtenLines = i;
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        int lineNumber = 0;
        BufferedReader bufferReader = null;
        try {
            bufferReader = Files.newBufferedReader(fileWithRomanNumbers.toPath(), Charset.defaultCharset());
            lineNumber = (int) bufferReader.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assertEquals(lineNumber, writtenLines);

        tearDown(fileWithRomanNumbers);
    }

    public void tearDown(File fileWithRomanNumbers) {
        boolean fileSuccessfullyDeleted = fileWithRomanNumbers.delete();
        if (!fileSuccessfullyDeleted) {
            System.out.println("There was an error with file(" +
                    fileWithRomanNumbers.getName() +
                    ") deletion. Please delete manually");
            throw new RuntimeException("file was not deleted");
        }
    }
}
