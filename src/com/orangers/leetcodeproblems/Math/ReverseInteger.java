package com.orangers.leetcodeproblems.Math;

public class ReverseInteger {

    /**
     * reverses an integer x by converting it to a string.
     * @param x - the integer to reverse.
     * @return the reversed integer (keeps sign i.e. -123 would become -321)
     */
    public int reverseViaToString(int x) {
        int r = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= -1;
        }
        String s = Integer.toString(x);

        StringBuilder rs = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            rs.append(s.charAt(i));
        }
        try {
            r = Integer.parseInt(rs.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        return r * sign;
    }

    /**
     * reverses an integer by using the modulo operator to 'extract' the last digit.
     * @param x - the integer to reverse.
     * @return the reversed integer (keeps sign i.e. -123 would become -321)
     */
    public int reverseViaModulo(int x) {
        int r = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x *= -1;
        }
        int prevReversed = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            r *= 10;
            r += digit;
            // check to see if the reversed would be > integer limit
            if (r / 10 != prevReversed) {
                return 0;
            }
            prevReversed = r;
        }
        return r * sign;
    }
}
