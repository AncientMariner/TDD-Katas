package org.xander.katas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindUniqueCharInStringTest {
    FindUniqueCharInString findUniqueCharInString;

    @Before
    public void setUp() {
        findUniqueCharInString = new FindUniqueCharInString();
    }

    @Test
    public void findFirstUniqueAllUnique() throws Exception {
        assertEquals('s', findUniqueCharInString.findFirstUnique("sparta"));
    }

    @Test
    public void findFirstUnique2LettersInTheBeginning() throws Exception {
        assertEquals('p', findUniqueCharInString.findFirstUnique("ssparta"));
    }

    @Test
    public void findFirstUnique2LettersInTheBeginning1() throws Exception {
        assertEquals('a', findUniqueCharInString.findFirstUnique("ssample"));
    }

    @Test
    public void findFirstUniqueALotOfChars() throws Exception {
        assertEquals('t', findUniqueCharInString.findFirstUnique("ttssppaarrtaat"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void findFirstUniqueNoUnique() throws Exception {
        assertEquals('t', findUniqueCharInString.findFirstUnique("ccc"));
    }

    @Test
    public void findFirstUniqueLastUnique() throws Exception {
        assertEquals('a', findUniqueCharInString.findFirstUnique("ccca"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstUniqueEmpty() throws Exception {
        assertEquals('s', findUniqueCharInString.findFirstUnique(""));
    }

    @Test
    public void findFirstUniqueOneChar() throws Exception {
        assertEquals('a', findUniqueCharInString.findFirstUnique("a"));
    }
}
