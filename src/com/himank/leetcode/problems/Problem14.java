package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Problem14 {

    // https://leetcode.com/problems/longest-common-prefix/
    public static void main(String[] args) {
        String[] st = {"flower", "flow", "flight"};
        System.out.println("longest common prefix = " + longestCommonPrefix(st));
    }

    public static String longestCommonPrefix(String[] strs) {
        int commonIndex = 0;
        List<String> str = Arrays.asList(strs);
        if (str.size() == 1)
            return str.get(0);
        boolean flag = true;
        int index = 0;
        while (flag) {
            if (str.get(0).length() <= index) {
                break;
            }
            char ch = str.get(0).charAt(index);
            for (String s : str) {
                if (s.length() <= index || s.charAt(index) != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                commonIndex++;
            index++;
        }
        return str.get(0).substring(0, commonIndex);
    }
}
