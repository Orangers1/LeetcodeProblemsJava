package com.orangers.leetcodeproblems.Substrings;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> seenCharacters = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (seenCharacters.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, seenCharacters.size());
                seenCharacters.clear();
                seenCharacters.put(s.charAt(i), i);
            } else {
                seenCharacters.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }
}
