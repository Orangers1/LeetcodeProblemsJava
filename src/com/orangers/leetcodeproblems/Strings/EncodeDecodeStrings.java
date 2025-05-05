package com.orangers.leetcodeproblems.Strings;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        String encoded = "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (Integer i : sizes) {
            res.append(i);
            res.append(",");
        }
        res.append("#"); // signal that we're at end of the list of sizes.
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> strings = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') { // go until the # delineation is hit
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') { // split the list of sizes into integers, build integer until comma hit then parse and repeat
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++; // step past the # delineation to get to the strings
        for (int sz : sizes) {
            strings.add(str.substring(i, i + sz));
            i += sz;
        }
        return strings;
    }

}
