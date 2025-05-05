package com.orangers.leetcodeproblems.Merging;

import java.util.*;

public class TestMergeKLists {

    public static void main(String[] args) {
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var ret = new ListNode();
        String num1 = "" + l1.val;
        String num2 = "" + l2.val;

        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        int sum = number2 + number1;
        String sumString = Integer.toString(sum);
        for (int i = 0; i < sumString.length(); i++) {
            ret.val = (sumString.charAt(i) - 48);
            if (i != sumString.length() - 1) {
                ret.next = new ListNode();
            }
        }
        return ret;
    }
}
