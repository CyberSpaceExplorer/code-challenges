package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReplaceAllWithWhitespaceRegexUnitTest {
    private static final String TEST_STR = "1 2 3 4 5   ";

    @Test
    public void givenString_whenReplaceBySingleCharClass_thenGetExpect() {
        String expected = "1_2_3_4_5___";
        String result = TEST_STR.replaceAll("\\s", "_");
        assertEquals(expected, result);
    }

    @Test
    public void givenString_whenReplaceBySingleCharClassWithPlus_thenGetExpect() {
        String expected = "1_2_3_4_5_";
        String result = TEST_STR.replaceAll("\\s+", "_");
        assertEquals(expected, result);
    }

    @Test
    public void givenString_whenRemoveByWhitespace_thenGetSameResult() {
        String expected = "12345";
        String result1 = TEST_STR.replaceAll("\\s", "");
        String result2 = TEST_STR.replaceAll("\\s+", "");
        assertEquals(expected, result1);
        assertEquals(result1, result2);
    }

    @Test
    public void givenString_whenReplaceBySingleCharClassWithPlusAtEnd_thenGetExpect() {

        String[] expected = {"1", "2", "3", "4", "5"};
        String[] result = TEST_STR.replaceAll("\\s+$", "").split(" ");
        System.out.print(Arrays.asList(result));
        assertArrayEquals(expected,result);
    }
}
