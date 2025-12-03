package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for PalindromeChecker.
 */
class PalindromeCheckerTest {

    private PalindromeChecker checker;

    @BeforeEach
    void setUp() {
        checker = new PalindromeChecker();
    }

    @Test
    @DisplayName("Simple lowercase palindrome should return true")
    void testSimpleLowercasePalindrome() {
        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("level"));
        assertTrue(checker.isPalindrome("madam"));
    }

    @Test
    @DisplayName("Palindrome with mixed case should return true")
    void testMixedCasePalindrome() {
        assertTrue(checker.isPalindrome("Radar"));
        assertTrue(checker.isPalindrome("Level"));
        assertTrue(checker.isPalindrome("RaDaR"));
    }

    @Test
    @DisplayName("Palindrome with spaces and punctuation should return true")
    void testPalindromeWithSpacesAndPunctuation() {
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("race car"));
        assertTrue(checker.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    @DisplayName("Single character should return true")
    void testSingleCharacter() {
        assertTrue(checker.isPalindrome("a"));
        assertTrue(checker.isPalindrome("A"));
    }

    @Test
    @DisplayName("Empty string should return true")
    void testEmptyString() {
        assertTrue(checker.isPalindrome(""));
    }

    @Test
    @DisplayName("Non-palindrome strings should return false")
    void testNonPalindrome() {
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
        assertFalse(checker.isPalindrome("world"));
        assertFalse(checker.isPalindrome("java"));
    }

    @Test
    @DisplayName("Numeric palindromes should return true")
    void testNumericPalindrome() {
        assertTrue(checker.isPalindrome("12321"));
        assertTrue(checker.isPalindrome("1221"));
        assertFalse(checker.isPalindrome("12345"));
    }

    @Test
    @DisplayName("Palindrome with special characters should return true")
    void testPalindromeWithSpecialCharacters() {
        assertTrue(checker.isPalindrome("A Santa at NASA"));
        assertTrue(checker.isPalindrome("Mr. Owl ate my metal worm"));
    }

    @Test
    @DisplayName("Null input should throw NullPointerException")
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> checker.isPalindrome(null));
    }
}

