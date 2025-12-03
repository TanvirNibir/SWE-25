package org.example;

/**
 * PalindromeChecker determines if a given string is a palindrome.
 * A palindrome reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
 */
public class PalindromeChecker {

    /**
     * Checks if the given string is a palindrome.
     * 
     * @param str the string to check
     * @return true if the string is a palindrome, false otherwise
     * @throws NullPointerException if str is null
     */
    public boolean isPalindrome(String str) {
        if (str == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        String normalized = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (normalized.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

