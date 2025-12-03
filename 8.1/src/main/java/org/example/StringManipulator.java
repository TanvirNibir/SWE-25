package org.example;

public class StringManipulator {

    public String concatenate(String str1, String str2) {
        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str1 + str2;
    }

    public int findLength(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public String convertToUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public String convertToLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public boolean containsSubstring(String str, String subStr) {
        if (str == null || subStr == null) {
            return false;
        }
        return str.contains(subStr);
    }
}
