package com.orangers.leetcodeproblems.Strings;

public class StringToInteger {

    /**
     * converts a string to a 32-bit signed integer (ignores leading whitespace, first character should be +/- to determine sign, assumes positive if neither present)
     * will stop reading in the integer at any non-number character (i.e. '1337c456' will just return 1337)
     * Rounds any values out of the integer range to their closest (i.e. round to 2^-31 or 2^31-1)
     * @param s - the string to convert to an integer
     * @return the converted integer from the string.
     */
    public int myAtoi(String s) {
        s = s.strip(); // remove whitespace from front and back
        if (s.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int value = 0;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        if (s.charAt(0) == '+') {
            start = 1;
        }
        int prevInt = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                break;
            }
            value *= 10;

            value += s.charAt(i) - '0';
            if (value / 10 != prevInt) {
                if (sign < 0) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            prevInt = value;
        }

        return value * sign;
    }
}
