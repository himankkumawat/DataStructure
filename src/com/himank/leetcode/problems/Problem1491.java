package com.himank.leetcode.problems;

public class Problem1491 {

    // https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println("Average salary is : " + average(salary));
    }

    public static double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum = 0;

        for (int sal : salary) {
            sum += sal;
            minSalary = Math.min(minSalary, sal);
            maxSalary = Math.max(maxSalary, sal);
        }
        return (double)(sum - minSalary - maxSalary) / (double)(salary.length - 2);
    }
}
