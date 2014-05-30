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
        assertEquals("A\nAA\nA", result);
    }

    @Test
    public void testTwoLetters() {
        char aba = 'B';

        String result = letterDiamond.buildADiamond(aba);
        assertEquals(" A\nB B\n A", result);
    }

    @Test
    public void testMoreLetters() {
        char aba = 'F';

        String result = letterDiamond.buildADiamond(aba);
        assertEquals("     A\n" +
                     "    B B\n" +
                     "   C   C\n" +
                     "  D     D\n" +
                     " E       E\n" +
                     "F         F\n" +
                     " E       E\n" +
                     "  D     D\n" +
                     "   C   C\n" +
                     "    B B\n" +
                     "     A", result);
    }


    @Test
    public void test() {
        char aba = 'Q';

        String result = letterDiamond.buildADiamond(aba);
        assertEquals("                A\n" +
                     "               B B\n" +
                     "              C   C\n" +
                     "             D     D\n" +
                     "            E       E\n" +
                     "           F         F\n" +
                     "          G           G\n" +
                     "         H             H\n" +
                     "        I               I\n" +
                     "       J                 J\n" +
                     "      K                   K\n" +
                     "     L                     L\n" +
                     "    M                       M\n" +
                     "   N                         N\n" +
                     "  O                           O\n" +
                     " P                             P\n" +
                     "Q                               Q\n" +
                     " P                             P\n" +
                     "  O                           O\n" +
                     "   N                         N\n" +
                     "    M                       M\n" +
                     "     L                     L\n" +
                     "      K                   K\n" +
                     "       J                 J\n" +
                     "        I               I\n" +
                     "         H             H\n" +
                     "          G           G\n" +
                     "           F         F\n" +
                     "            E       E\n" +
                     "             D     D\n" +
                     "              C   C\n" +
                     "               B B\n" +
                     "                A", result);
    }

    @Test
    public void testZ() {
        char aba = 'Z';

        String result = letterDiamond.buildADiamond(aba);
        assertEquals("                         A\n" +
                     "                        B B\n" +
                     "                       C   C\n" +
                     "                      D     D\n" +
                     "                     E       E\n" +
                     "                    F         F\n" +
                     "                   G           G\n" +
                     "                  H             H\n" +
                     "                 I               I\n" +
                     "                J                 J\n" +
                     "               K                   K\n" +
                     "              L                     L\n" +
                     "             M                       M\n" +
                     "            N                         N\n" +
                     "           O                           O\n" +
                     "          P                             P\n" +
                     "         Q                               Q\n" +
                     "        R                                 R\n" +
                     "       S                                   S\n" +
                     "      T                                     T\n" +
                     "     U                                       U\n" +
                     "    V                                         V\n" +
                     "   W                                           W\n" +
                     "  X                                             X\n" +
                     " Y                                               Y\n" +
                     "Z                                                 Z\n" +
                     " Y                                               Y\n" +
                     "  X                                             X\n" +
                     "   W                                           W\n" +
                     "    V                                         V\n" +
                     "     U                                       U\n" +
                     "      T                                     T\n" +
                     "       S                                   S\n" +
                     "        R                                 R\n" +
                     "         Q                               Q\n" +
                     "          P                             P\n" +
                     "           O                           O\n" +
                     "            N                         N\n" +
                     "             M                       M\n" +
                     "              L                     L\n" +
                     "               K                   K\n" +
                     "                J                 J\n" +
                     "                 I               I\n" +
                     "                  H             H\n" +
                     "                   G           G\n" +
                     "                    F         F\n" +
                     "                     E       E\n" +
                     "                      D     D\n" +
                     "                       C   C\n" +
                     "                        B B\n" +
                     "                         A", result);
    }
}
