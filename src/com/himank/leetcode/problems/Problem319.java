package com.himank.leetcode.problems;

public class Problem319 {

    // https://leetcode.com/problems/bulb-switcher/
    public static void main(String[] args) {
        int no = 45;
        System.out.println("Total number of bulbs on are : " + bulbSwitch(no));
    }

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
