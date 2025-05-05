package com.orangers.leetcodeproblems.Arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    /**
     * Returns the length of the longest consecutive sequence of elements that can be formed.
     * <br>
     * problem <a href="https://neetcode.io/problems/longest-consecutive-sequence">can be viewed here</a>
     * @param nums the array to use to be able to form consecutive sequences
     * @return the length of the longest consecutive sequence of elements that can be formed
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        HashSet<Integer> numbers = new HashSet<>();
        for (int k : nums) {
            numbers.add(k);
        }

        HashSet<Integer> sequenceStarts = new HashSet<>();

        for (int num : nums) {

            if (!numbers.contains(num - 1)) {
                sequenceStarts.add(num);
            }
        }

        int currentSequence = 1;

        for (Integer i : sequenceStarts) {
            Integer j = i;
            while (numbers.contains(j + 1)) {
                currentSequence++;
                j++;
            }
            if (currentSequence > longest) {
                longest = currentSequence;
            }
            currentSequence = 1;
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] testArray1 = {2, 20, 4, 10, 3, 4, 5};

        int result = longestConsecutive(testArray1);
        System.out.println("Result: " + result);
    }
}