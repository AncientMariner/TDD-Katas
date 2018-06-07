package other;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelCalculationTest {

    ExcelCalculation excelCalculation;
    @Before
    public void setUp() {
        excelCalculation = new ExcelCalculation();
    }

    @Test
    public void test0() {
        String result = excelCalculation.calculate(0);
        assertEquals("", result);
    }

    @Test
    public void testOneLetter() {
        String result = excelCalculation.calculate(10);
        assertEquals("j", result);
    }

    @Test
    public void testOneLetter25() {
        String result = excelCalculation.calculate(25);
        assertEquals("y", result);
    }
    @Test
    public void testOneLetter26() {
        String result = excelCalculation.calculate(26);
        assertEquals("z", result);
    }

    @Test
    public void testTwoLetters() {
        String result = excelCalculation.calculate(27);
        assertEquals("aa", result);
    }

    @Test
    public void testTwoLetters34() {
        String result = excelCalculation.calculate(34);
        assertEquals("ah", result);
    }

    @Test
    public void testTwoLetters40() {
        String result = excelCalculation.calculate(40);
        assertEquals("an", result);
    }

    @Test
    public void testTwoLetters52() {
        String result = excelCalculation.calculate(52);
        assertEquals("az", result);
    }

    @Test
    public void testTwoLetters53() {
        String result = excelCalculation.calculate(53);
        assertEquals("ba", result);
    }

    @Test
    public void testTwoLetters57() {
        String result = excelCalculation.calculate(57);
        assertEquals("be", result);
    }

    @Test
    public void testTwoLetters134() {
        String result = excelCalculation.calculate(134);
        assertEquals("ed", result);
    }

    @Test
    public void testTwoLetters648() {
        String result = excelCalculation.calculate(648);
        assertEquals("xx", result);
    }

    @Test
    public void testTwoLetters624() {
        String result = excelCalculation.calculate(624);
        assertEquals("wz", result);
    }

    @Test
    public void testTwoLetters650() {
        String result = excelCalculation.calculate(650);
        assertEquals("xz", result);
    }

    @Test
    public void testTwoLetters651() {
        String result = excelCalculation.calculate(651);
        assertEquals("ya", result);
    }

    @Test
    public void testTwoLetters675() {
        String result = excelCalculation.calculate(675);
        assertEquals("yy", result);
    }

    @Test
    public void testTwoLetters676() {
        String result = excelCalculation.calculate(676);
        assertEquals("yz", result);
    }

    @Test
    public void testTwoLetters677() {
        String result = excelCalculation.calculate(677);
        assertEquals("za", result);
    }

    @Test
    public void testTwoLetters701() {
        String result = excelCalculation.calculate(701);
        assertEquals("zy", result);
    }

    @Test
    public void testTwoLetters702() {
        String result = excelCalculation.calculate(702);
        assertEquals("zz", result);
    }

    @Test
    public void testTwoLetters703() {
        String result = excelCalculation.calculate(703);
        assertEquals("aaa", result);
    }

    @Test
    public void testTwoLetters705() {
        String result = excelCalculation.calculate(705);
        assertEquals("aac", result);
    }

    @Test
    public void testTwoLetters1389() {
        String result = excelCalculation.calculate(1389);
        assertEquals("bak", result);
    }

    @Test
    public void testTwoLetters2058() {
        String result = excelCalculation.calculate(2058);
        assertEquals("cad", result);
    }

    @Test
    public void testTwoLetters2097() {
        String result = excelCalculation.calculate(2097);
        assertEquals("cbq", result);
    }
}
