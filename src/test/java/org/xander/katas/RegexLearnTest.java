package org.xander.katas;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.*;

public class RegexLearnTest {
    RegexLearn regexLearn;

    @Before
    public void setUp() {
        regexLearn = new RegexLearn();
    }

    @Test
    public void Basic() {
        assertNotNull(regexLearn);
    }

    /** string literals---------------------------------------------*/
    @Test
    public void Beginning() {
        Pattern pattern = Pattern.compile(" to ");
        Matcher matcher = pattern.matcher("regex to find");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void Beginning1() {
        Pattern pattern = Pattern.compile("sea shells");
        Matcher matcher = pattern.matcher("She sells sea shells at the sea shore");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void Foo() {
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foofoofoo");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    /**way to avoid meta character - precede with a backslash
     or enclose it with \Q(beginning) \E (end) */
    @Test
    public void CatWithMetacharacterDotMeansAnyCharacter() {
        Pattern pattern = Pattern.compile("cat.");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    /** character classes---------------------------------------------*/
    @Test
    public void CatWithMetacharacter_A_or_B_or_C() {
        Pattern pattern = Pattern.compile("[abc]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_except_A_or_B_or_C() {
        Pattern pattern = Pattern.compile("[^abc]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_a_z_A_Z_inclusive() {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_a_d_or_m_p_union() {
        Pattern pattern = Pattern.compile("[a-d[m-p]]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_d_e_or_f_intersection() {
        Pattern pattern = Pattern.compile("[a-z&&[def]]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertFalse(result);
    }

    @Test
    public void CatWithMetacharacter_a_z_except_b_or_c_ad_z_substraction() {
        Pattern pattern = Pattern.compile("[a-z&&[^bc]]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_a_z_and_not_m_p__a_lq_z_substraction() {
        Pattern pattern = Pattern.compile("[a-z&&[^m-p]]");
        Matcher matcher = pattern.matcher("cats");

        boolean result = regexLearn.findTheResult(matcher);

        assertTrue(result);
    }

    @Test
    public void CatWithMetacharacter_bcr() {
        Pattern pattern = Pattern.compile("[bcr]");
        Matcher matcher1 = pattern.matcher("cat");
        Matcher matcher2= pattern.matcher("bat");
        Matcher matcher3 = pattern.matcher("rat");
        Matcher matcher4 = pattern.matcher("hat");

        boolean result1 = regexLearn.findTheResult(matcher1);
        boolean result2 = regexLearn.findTheResult(matcher2);
        boolean result3 = regexLearn.findTheResult(matcher3);
        boolean result4 = regexLearn.findTheResult(matcher4);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
    }

    @Test
    public void CatWithMetacharacter_Combination() {
        Pattern pattern = Pattern.compile("[cat[1-3]]");
        Matcher matcher1 = pattern.matcher("cat2");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void CatWithMetacharacter_Intersection() {
        Pattern pattern = Pattern.compile("[a-z&&[e-z]]");
        Matcher matcher1 = pattern.matcher("cat2");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void CatWithMetacharacter_Substraction() {
        Pattern pattern = Pattern.compile("[a-z&&[^a-e]]");
        Matcher matcher1 = pattern.matcher("cat2");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    /** predefined character classes---------------------------------------------*/
    @Test
    public void AnyChar() {
        Pattern pattern = Pattern.compile(".");
        Matcher matcher1 = pattern.matcher("cat");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void ADigit() {
        Pattern pattern = Pattern.compile("\\d");
//        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher1 = pattern.matcher("cat2");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void NonDigit() {
        Pattern pattern = Pattern.compile("\\D");
//        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher1 = pattern.matcher("cat2");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void AWhiteSpaceChar() {
        Pattern pattern = Pattern.compile("\\s");
//        Pattern pattern = Pattern.compile("\\t\\n\\x0B\\f\\r");
        Matcher matcher1 = pattern.matcher("cat2 ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void NonWhiteSpaceChar() {
        Pattern pattern = Pattern.compile("\\S");
//        Pattern pattern = Pattern.compile("^\s");
        Matcher matcher1 = pattern.matcher("cat2 ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void AWordChar() {
        Pattern pattern = Pattern.compile("\\w");
//        Pattern pattern = Pattern.compile("[a-zA-Z_0-9]");
        Matcher matcher1 = pattern.matcher("cat2 ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void NonWordChar() {
        Pattern pattern = Pattern.compile("\\W");
//        Pattern pattern = Pattern.compile("^\\w");
        Matcher matcher1 = pattern.matcher("cat2 ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    /** quantifiers---------------------------------------------*/

    @Test
    public void QuentifierChar_once_or_not_at_all_Greedy1() {
        Pattern pattern = Pattern.compile("a?");
        Matcher matcher1 = pattern.matcher("aaaaa");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void QuentifierChar_zero_or_more_times_Greedy2() {
        Pattern pattern = Pattern.compile("a*");
        Matcher matcher1 = pattern.matcher("aaaaa");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void QuentifierChar_one_or_more_times_Greedy3() {
        Pattern pattern = Pattern.compile("a+");
        Matcher matcher1 = pattern.matcher("cata2aa ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void QuentifierCharMatchSpecificNumberOfTimesAtLeastTo2_6() {
        Pattern pattern = Pattern.compile("aa{2,6}");
        Matcher matcher1 = pattern.matcher("cata2aa ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    @Test
    public void QuentifierCaptureGroupTwoTimes() {
        Pattern pattern = Pattern.compile("(cat){2}");
        Matcher matcher1 = pattern.matcher("catcata2catacata ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void QuentifierCaptureGroupTwoTimes1() {
        Pattern pattern = Pattern.compile("cat{2}"); // applies only to the near letter - 't'
        Matcher matcher1 = pattern.matcher("catcata2catacata ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    @Test
    public void QuentifierCaptureGroupTwoTimes2() {
        Pattern pattern = Pattern.compile("[abc]{2}");
        Matcher matcher1 = pattern.matcher("catcata2catacata ");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    /**
     * Greedy quantifiers are considered "greedy" because they force
     * the matcher to read in, or eat, the entire input string prior
     * to attempting the first match. If the first match attempt
     * (the entire input string) fails, the matcher backs off
     * the input string by one character and tries again,
     * repeating the process until a match is found
     * or there are no more characters left to back off from.
     * Depending on the quantifier used in the expression,
     * the last thing it will try matching against is 1 or 0 characters.*/

    //reluctant ~ lazy
    /**
     * The reluctant quantifiers, however, take the opposite approach:
     * They start at the beginning of the input string,
     * then reluctantly eat one character at a time looking for a match.
     * The last thing they try is the entire input string.*/


    //possessive - wants everything
    /**
     * The possessive quantifiers always eat the entire input string,
     * trying once (and only once) for a match.
     * Unlike the greedy quantifiers, possessive quantifiers never back off,
     * even if doing so would allow the overall match to succeed.*/


    /**
     * quantifier .* finds "anything", zero or more times,
     * followed by the letters "f" "o" "o".
     * Because the quantifier is greedy,
     * the .* portion of the expression first eats the entire input string.
     * At this point, the overall expression cannot succeed,
     * because the last three letters ("f" "o" "o") have already been consumed.
     * So the matcher slowly backs off one letter at a time until
     * the rightmost occurrence of "foo" has been regurgitated,
     * at which point the match succeeds and the search ends.*/
    @Test
    public void QuentifierComparisonGreedy_0_or_more_times() {
        Pattern pattern = Pattern.compile(".*foo");
        Matcher matcher1 = pattern.matcher("xfooxxxxxxfoo");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    /**
    * it starts by first consuming "nothing".
     * Because "foo" doesn't appear at the beginning of the string,
     * it's forced to swallow the first letter (an "x"),
     * which triggers the first match at 0 and 4.
     * Our test harness continues the process until the input string is exhausted.
     * It finds another match at 4 and 13. */
    @Test
    public void QuentifierComparisonReluctant_0_or_more_times() {
        Pattern pattern = Pattern.compile(".*?foo");
        Matcher matcher1 = pattern.matcher("xfooxxxxxxfoo");


        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    /**
     * fails to find a match because the quantifier is possessive.
     * The entire input string is consumed by .*+,
     * leaving nothing left over to satisfy the "foo" at the end of the expression.
     * Use a possessive quantifier for situations
     * where you want to seize all of something without ever backing off;
     * it will outperform the equivalent greedy quantifier in cases
     * where the match is not immediately found*/
    @Test
    public void QuentifierComparisonPossessive_0_or_more_times() {
        Pattern pattern = Pattern.compile(".*+foo");
        Matcher matcher1 = pattern.matcher("xfooxxxxxxfoo");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    /** capturing groups---------------------------------------------*/

    @Test
    public void CapruteGroup() {
        Pattern pattern = Pattern.compile("((a)(b(c)))");
        Matcher matcher1 = pattern.matcher("z");

        assertEquals(4, matcher1.groupCount());
    }

    @Test
    public void BackReferencesAnyTwoDigits() {
        Pattern pattern = Pattern.compile("(\\d\\d)\\1");
        Matcher matcher1 = pattern.matcher("1212");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void BackReferencesAnyTwoDigitsNotFound() {
        Pattern pattern = Pattern.compile("(\\d\\d)\\1");
        Matcher matcher1 = pattern.matcher("1234");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    /** boundary mathers---------------------------------------------*/

    @Test
    public void BeginningOfTheLineTheEndOfTheLine() {
        Pattern pattern = Pattern.compile("^dog$");
        Matcher matcher1 = pattern.matcher("dog");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void BeginningOfTheLineTheEndOfTheLineAnotherOne() {
        Pattern pattern = Pattern.compile("\\s*dog$");
        Matcher matcher1 = pattern.matcher("     dog");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void BeginningOfTheLineTheEndOfTheLineAnotherOne1() {
        Pattern pattern = Pattern.compile("^dog\\w*");
        Matcher matcher1 = pattern.matcher("dogcatmouse");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void BeginningOfTheLineTheEndOfTheLineFalse() {
        Pattern pattern = Pattern.compile("^dog$");
        Matcher matcher1 = pattern.matcher(" dog");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    @Test
    public void WordBoundary() {
        Pattern pattern = Pattern.compile("\\bdog\\b");
        Matcher matcher1 = pattern.matcher("cat and dog and cat");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void WordBoundary1() {
        Pattern pattern = Pattern.compile("\\bdog\\b");
        Matcher matcher1 = pattern.matcher("cat and doggie and cat");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    @Test
    public void NonWordBoundary() {
        Pattern pattern = Pattern.compile("\\bdog\\B");
        Matcher matcher1 = pattern.matcher("cat and dog and cat");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertFalse(result1);
    }

    @Test
    public void NonWordBoundary1() {
        Pattern pattern = Pattern.compile("\\bdog\\B");
        Matcher matcher1 = pattern.matcher("cat and doggie and cat");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void EndOfThePreviousMatch0() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher1 = pattern.matcher("dog and dog");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void EndOfThePreviousMatch1() {
        Pattern pattern = Pattern.compile("\\Gdog");
        Matcher matcher1 = pattern.matcher("dog and dog");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void CaseInsensitiveAndOtherFlags() {
//        Pattern pattern = Pattern.compile("dog", Pattern.CASE_INSENSITIVE  | Pattern.UNIX_LINES);
        final int flags = Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
        Pattern pattern = Pattern.compile("dog", flags);
//        Pattern pattern = Pattern.compile("dog");

        Matcher matcher1 = pattern.matcher("DoG and dOg");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void CaseInsensitiveFlagsWithinExpression() {
        Pattern pattern = Pattern.compile("(?i)foo");
        Matcher matcher1 = pattern.matcher("FOOfooFoOfoO");

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }

    @Test
    public void OneLineMathes() {
        assertTrue(Pattern.matches("\\d","1"));
    }

    @Test
    public void ExtractWords() {
        final String REGEX = ":";
        final String INPUT = "one:two:three:four:five";

        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);

        assertEquals("one", items[0]);
        assertEquals("two", items[1]);
        assertEquals("three", items[2]);
        assertEquals("four", items[3]);
        assertEquals("five", items[4]);
    }

    @Test
    public void ExtractWordsAnotherOne() {
        final String REGEX = "\\d";
        final String INPUT = "one9two4three7four1five";

        Pattern p = Pattern.compile(REGEX);
        String[] items = p.split(INPUT);
//        String[] items = p.split(INPUT,2);  number is a limit

        assertEquals("one", items[0]);
        assertEquals("two", items[1]);
        assertEquals("three", items[2]);
        assertEquals("four", items[3]);
        assertEquals("five", items[4]);
    }

    @Test
    public void GenerateRegexFromString() {
        String quote = Pattern.quote("FOOfooFoOfoO");
        assertEquals("\\QFOOfooFoOfoO\\E", quote);
    }

    @Test
    public void MatcherMethodsMatches() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher1 = pattern.matcher("dog");

        assertTrue(matcher1.matches());
    }
    //difference is that matches requires the entire input sequence
    // to be matched, while lookingAt does not
    @Test
    public void MatcherMethodsLookingAt() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher1 = pattern.matcher("dog and cat");

        assertTrue(matcher1.lookingAt());
    }

    @Test
    public void MatcherMethodsFind() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher1 = pattern.matcher("cat and dog");

        assertTrue(matcher1.find());
    }

    @Test
    public void MatcherMethodsReplace() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher1 = pattern.matcher("cat and dog");
        String actualResult = matcher1.replaceAll("cat");
        assertEquals("cat and cat", actualResult);
    }

    @Test
    public void MatcherMethodsReplaceAnotherOne() {
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher1 = pattern.matcher("aabfooaabfooabfoob");
        String actualResult = matcher1.replaceAll("-");
        String actualResult1 = matcher1.replaceFirst("-");
        assertEquals("-foo-foo-foo-", actualResult);
        assertEquals("-fooaabfooabfoob", actualResult1);
    }

    @Test
    public void MatcherMethodsAppendReplacement() {
        Pattern pattern = Pattern.compile("a*b");
        Matcher matcher1 = pattern.matcher("aabfooaabfooabfoob");


        StringBuffer sb = new StringBuffer();
        while(matcher1.find()){
            matcher1.appendReplacement(sb,"-");
        }
//        matcher1.appendTail(sb);

        assertEquals("-foo-foo-foo-", sb.toString());
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void RegexException() {
        Pattern pattern = null;
        Matcher matcher = null;

        while (true) {
            try{
                pattern = Pattern.compile("\\?i)foo");
                matcher = pattern.matcher("foo");
            }
            catch(PatternSyntaxException pse){
                assertEquals("\\?i)foo", pse.getPattern());
                assertEquals("Unmatched closing ')'", pse.getDescription());
                assertEquals("Unmatched closing ')' near index 2\n\\?i)foo\n  ^", pse.getMessage());
                assertEquals(2, pse.getIndex());

                exit.expectSystemExitWithStatus(0);
                System.exit(0);
            }
        }
    }

    @Test
    public void FirstAndLastNamesAreTheSame() {
        String name = "dog";
        String regex = name + "\\s" + name;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(name + " " + name);

        boolean result1 = regexLearn.findTheResult(matcher1);

        assertTrue(result1);
    }
}
