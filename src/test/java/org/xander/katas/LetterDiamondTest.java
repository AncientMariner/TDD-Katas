package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LetterDiamondTest {
    LetterDiamond letterDiamond;

    @Before
    public void setUp() {
        letterDiamond = new LetterDiamond();
    }

    @Test
    public void testBasic() {
        assertNotNull(letterDiamond);
    }

    @Test
    public void testSimpleLetter() {
        char a = 'A';

        String result = letterDiamond.buildADiamond(a);
        assertEquals("A", result);
    }

    @Test
    public void testTwoLetters() {
        char aba = 'E';

        String result = letterDiamond.buildADiamond(aba);
        assertEquals("ABBA", result);
    }


}
