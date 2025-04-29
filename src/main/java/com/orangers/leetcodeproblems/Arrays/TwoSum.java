package com.orangers.leetcodeproblems.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
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
}
