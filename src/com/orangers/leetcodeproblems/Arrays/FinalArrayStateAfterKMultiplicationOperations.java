package com.orangers.leetcodeproblems.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.lang.Comparable;

public class FinalArrayStateAfterKMultiplicationOperations {
    public static void main(String[] args){
        int[] start = {2,1,3,5,6};
        int k = 5;
        int mult = 2;
        int[] expected = {8,4,6,5,6};
        FinalArrayState s = new FinalArrayState();
        int[] computed = s.getFinalState(start, k, mult);
        System.out.println("Received: " + Arrays.toString(computed) +
                ": expected: " + Arrays.toString(expected));
    }
    /*
    perform operation k times on nums
    operation is always as follows:
        - find min value in nums, first if multiple of min
        - replace min with min * multiplier
    return the list after the operation has been performed k times.
     */

    private static class FinalArrayState {
        public FinalArrayState(){

        }
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            //o(1) min getting
            // min heap
            // pop top of heap, get index associated, do operation on index, remake heap.
            PriorityQueue<Tuple> pq = buildMinHeap(nums);
            for (int i = 0; i < k; i++) {
                Tuple minimum = pq.poll();
                assert minimum != null;
                int minVal = minimum.first;
                int minIndex = minimum.last;
                nums[minIndex] = minVal*multiplier;
                pq.add(new Tuple(minVal*multiplier, minIndex));
            }
            return nums;
        }

        private PriorityQueue<Tuple> buildMinHeap(int[] nums) {
            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add(new Tuple(nums[i], i));
            }
            return pq;
        }

        private class Tuple implements Comparable<Tuple> {
            int first;
            int last;

            public Tuple(int first, int last) {
                this.first = first;
                this.last = last;
            }

            @Override
            public int compareTo(Tuple other) {

                if (this.first > other.first) {
                    return 1;
                } else if (this.first < other.first) {
                    return -1;
                } else {
                    if (this.last > other.last) {
                        return 1;
                    } else if (this.last < other.last) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}
