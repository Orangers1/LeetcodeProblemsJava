package com.orangers.leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubstringWithConcatenation {

    public static void main(String[] args){

        int x = reverseInt(365);
        int y = reverseInt(-12);
        int z = reverseInt(Integer.MAX_VALUE);
        System.out.println("365 reversed to: " + x);
        System.out.println("-12 reversed to: " + y);
        System.out.println(Integer.MAX_VALUE + " reversed to: " + z);

    }
    /*
   All strings of words are of same length
   concatenated string conta    ins all strings of any permutation of words concatenated
       - contains all the words in any order put together
   this means all substrings will be of the total length of the words
   */
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> Answer = new ArrayList<>();
        HashMap<String, Integer> wordSet = new HashMap<>();

        int individualWordLength = words[0].length();
        int substringLength = words.length * individualWordLength;

        for(String st : words){
            wordSet.put(st, wordSet.getOrDefault(st,0) + 1);
        }

        for(int i = 0; i < s.length()+1 - substringLength; i++){
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            for(int j = i, k = i; j+individualWordLength <= s.length(); j = j + individualWordLength) {
                String word = s.substring(j, j + individualWordLength);
                temp.put(word, temp.getOrDefault(word,0)+1);
                count++;

                if(count==words.length){
                    if(wordSet.equals(temp))
                        Answer.add(k);
                }
                String remove = s.substring(k, k+individualWordLength);
                temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                count--;
                k = k + individualWordLength;
            }
        }

        return Answer;
    }




    private static int reverseInteger(int x) {
        int reversed = 0;
        int sign = 1;
        if(x < 0){
            sign = -1;
            x*=-1;
        }

        int prevReversed = 0;
        while (x > 0){
            reversed*=10;
            int digit = x % 10;
            reversed+=digit;
            x/=10;

            if(reversed / 10 != prevReversed) {
                return 0;
            }
            prevReversed = reversed;
        }
        return reversed*sign;
    }

    private static int reverseInt(int x) {
        int sign = 1;
        if(x < 0) {
            sign = -1;
            x*=-1;
        }
        String s = Integer.toString(x);

        String rs = "";
        for (int i = s.length(); i > 0; i--){
            rs += s.charAt(i-1);
        }
        int r = 0;
        try {
            r = Integer.parseInt(rs);
        }
        catch(NumberFormatException e){
            return 0;
        }
        return r*sign;
    }



}
