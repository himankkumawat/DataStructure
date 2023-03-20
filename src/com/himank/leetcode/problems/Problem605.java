package com.himank.leetcode.problems;

public class Problem605 {

    // https://leetcode.com/problems/can-place-flowers/
    public static void main(String[] args) {
//        int[] nums = {1, 0, 0, 0, 1};
        int[] nums = {0, 0, 1, 0, 0};
        int n = 1;
        System.out.println("Output : " + canPlaceFlowers(nums, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return flowerbed[0] == 1 ? n == 0 : n == 1;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 2] == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i > 0 && i < flowerbed.length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        System.out.println("n = " + n);
        return n <= 0;
    }
}
