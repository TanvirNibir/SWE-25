package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    private StringManipulator manipulator;

    @BeforeEach
    void setUp() {
        manipulator = new StringManipulator();
    }

    @Test
    @DisplayName("Test concatenate with normal strings")
    void testConcatenateNormalStrings() {
        String result = manipulator.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    @DisplayName("Test concatenate with empty strings")
    void testConcatenateEmptyStrings() {
        assertEquals("", manipulator.concatenate("", ""));
        assertEquals("Hello", manipulator.concatenate("Hello", ""));
        assertEquals("World", manipulator.concatenate("", "World"));
    }

    @Test
    @DisplayName("Test concatenate with null strings")
    void testConcatenateWithNull() {
        assertEquals("World", manipulator.concatenate(null, "World"));
        assertEquals("Hello", manipulator.concatenate("Hello", null));
        assertEquals("", manipulator.concatenate(null, null));
    }

    @Test
    @DisplayName("Test concatenate with special characters")
    void testConcatenateSpecialCharacters() {
        assertEquals("Hello, World!", manipulator.concatenate("Hello, ", "World!"));
        assertEquals("123456", manipulator.concatenate("123", "456"));
    }

    @Test
    @DisplayName("Test findLength with normal string")
    void testFindLengthNormalString() {
        assertEquals(5, manipulator.findLength("Hello"));
        assertEquals(0, manipulator.findLength(""));
        assertEquals(11, manipulator.findLength("Hello World"));
    }

    @Test
    @DisplayName("Test findLength with null string")
    void testFindLengthNullString() {
        assertEquals(0, manipulator.findLength(null));
    }

    @Test
    @DisplayName("Test findLength with whitespace")
    void testFindLengthWhitespace() {
        assertEquals(1, manipulator.findLength(" "));
        assertEquals(3, manipulator.findLength("   "));
    }

    @Test
    @DisplayName("Test convertToUpperCase with normal string")
    void testConvertToUpperCaseNormalString() {
        assertEquals("HELLO", manipulator.convertToUpperCase("Hello"));
        assertEquals("HELLO WORLD", manipulator.convertToUpperCase("Hello World"));
        assertEquals("123ABC", manipulator.convertToUpperCase("123abc"));
    }

    @Test
    @DisplayName("Test convertToUpperCase with already uppercase string")
    void testConvertToUpperCaseAlreadyUppercase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("HELLO"));
    }

    @Test
    @DisplayName("Test convertToUpperCase with null string")
    void testConvertToUpperCaseNullString() {
        assertNull(manipulator.convertToUpperCase(null));
    }

    @Test
    @DisplayName("Test convertToUpperCase with mixed case")
    void testConvertToUpperCaseMixedCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("HeLlO"));
    }

    @Test
    @DisplayName("Test convertToLowerCase with normal string")
    void testConvertToLowerCaseNormalString() {
        assertEquals("hello", manipulator.convertToLowerCase("Hello"));
        assertEquals("hello world", manipulator.convertToLowerCase("Hello World"));
        assertEquals("123abc", manipulator.convertToLowerCase("123ABC"));
    }

    @Test
    @DisplayName("Test convertToLowerCase with already lowercase string")
    void testConvertToLowerCaseAlreadyLowercase() {
        assertEquals("hello", manipulator.convertToLowerCase("hello"));
    }

    @Test
    @DisplayName("Test convertToLowerCase with null string")
    void testConvertToLowerCaseNullString() {
        assertNull(manipulator.convertToLowerCase(null));
    }

    @Test
    @DisplayName("Test convertToLowerCase with mixed case")
    void testConvertToLowerCaseMixedCase() {
        assertEquals("hello", manipulator.convertToLowerCase("HeLlO"));
    }

    @Test
    @DisplayName("Test containsSubstring with existing substring")
    void testContainsSubstringExisting() {
        assertTrue(manipulator.containsSubstring("Hello World", "Hello"));
        assertTrue(manipulator.containsSubstring("Hello World", "World"));
        assertTrue(manipulator.containsSubstring("Hello World", "lo Wo"));
    }

    @Test
    @DisplayName("Test containsSubstring with non-existing substring")
    void testContainsSubstringNonExisting() {
        assertFalse(manipulator.containsSubstring("Hello World", "xyz"));
        assertFalse(manipulator.containsSubstring("Hello", "Hello World"));
    }

    @Test
    @DisplayName("Test containsSubstring with empty strings")
    void testContainsSubstringEmptyStrings() {
        assertTrue(manipulator.containsSubstring("Hello", ""));
        assertTrue(manipulator.containsSubstring("", ""));
    }

    @Test
    @DisplayName("Test containsSubstring with null strings")
    void testContainsSubstringNullStrings() {
        assertFalse(manipulator.containsSubstring(null, "Hello"));
        assertFalse(manipulator.containsSubstring("Hello", null));
        assertFalse(manipulator.containsSubstring(null, null));
    }

    @Test
    @DisplayName("Test containsSubstring case sensitivity")
    void testContainsSubstringCaseSensitive() {
        assertTrue(manipulator.containsSubstring("Hello World", "Hello"));
        assertFalse(manipulator.containsSubstring("Hello World", "hello"));
        assertFalse(manipulator.containsSubstring("Hello World", "HELLO"));
    }

    @Test
    @DisplayName("Test containsSubstring with exact match")
    void testContainsSubstringExactMatch() {
        assertTrue(manipulator.containsSubstring("Hello", "Hello"));
    }
}
