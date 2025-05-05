package com.orangers.leetcodeproblems.Arrays;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequent {
    class IntegerFrequency implements Comparable<IntegerFrequency> {
        int value;
        public int frequency;

        public IntegerFrequency(int value, int frequency){
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(IntegerFrequency i) {
            return i.frequency-this.frequency;
        }
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
}
