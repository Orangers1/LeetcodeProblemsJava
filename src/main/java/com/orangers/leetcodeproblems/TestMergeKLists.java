package com.orangers.leetcodeproblems;

import jdk.jshell.spi.ExecutionControl;

import java.sql.Array;
import java.util.*;

public class TestMergeKLists {

    public static void main(String[] args){
//        String[] strings = new String[5];
//        strings[0] = "act";
//        strings[1] = "pots";
//        strings[2] = "tops";
//        strings[3] = "stop";
//        strings[4] = "cat";
//        ArrayList<List<String>> anagrams = (ArrayList<List<String>>) groupAnagrams(strings);
//        for(List<String> list : anagrams){
//            System.out.print("[");
//            for(int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i) + ", ");
//            }
//            System.out.println("]");
//        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> valueIndecisMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueIndecisMap.containsKey(target - nums[i])){
                ArrayList<Integer> list = valueIndecisMap.get(target-nums[i]);
                int val = list.get(0);
                return new int[]{i, val};
            }
            if (valueIndecisMap.containsKey(nums[i])) {
                ArrayList<Integer> list = valueIndecisMap.get(nums[i]);
                list.add(i);
                valueIndecisMap.put(nums[i], list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                valueIndecisMap.put(nums[i], list);
            }
        }
        return new int[1];
    }



    public int[] topKFrequent(int[] nums, int k){
        // structure that associates numbers to their frequency, can return top X of them
        PriorityQueue<IntegerFrequency> queue = new PriorityQueue<>();
        HashMap<Integer, IntegerFrequency> map = new HashMap<>();
        for(Integer i : nums){
            if(map.containsKey(i)){
                IntegerFrequency frequency = map.get(i);
                frequency.frequency+=1;
                map.put(i, frequency);
            }else{
                map.put(i, new IntegerFrequency(i, 0));
            }
        }
        queue.addAll(map.values());
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = Objects.requireNonNull(queue.poll()).value;
        }
        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<ArrayWrapper, List<String>> result = new HashMap<>(); // map character count of each string to list of anagrams

        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a'] += 1;
            }
            List<String> putList = new ArrayList<>();
            ArrayWrapper wrapper = new ArrayWrapper(count);
            if(result.containsKey(wrapper)){
                putList = result.get(wrapper);
            }
            putList.add(s);
            result.put(wrapper, putList);
        }
        return new ArrayList<>(result.values());
    }
}
class ArrayWrapper{
    private final int[] array;
    public ArrayWrapper(int[] array) {
        this.array = array;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayWrapper that = (ArrayWrapper) o;
        return Arrays.equals(array, that.array);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

class IntegerFrequency implements Comparable<IntegerFrequency> {
    int value;
    int frequency;
    public IntegerFrequency(int value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(IntegerFrequency i) {
        return i.frequency-this.frequency;
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var ret = new ListNode();
        String num1 = "" + l1.val;
        String num2 = "" + l2.val;

        if(!num1.equals("0")){
            
        }
        if(!num2.equals("0")){

        }

        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        int sum = number2 + number1;
        String sumString = Integer.toString(sum);
        for(int i = 0; i < sumString.length(); i++){
            ret.val = (sumString.charAt(i)-48);
            if(i != sumString.length() -1){
                ret.next = new ListNode();
            }
        }
        return ret;
    }
}
