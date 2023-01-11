package com.himank.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    private static Map<Integer, Integer> robberySum = new HashMap<>();

    public static void main(String[] args) {
//        int[] arr = {1,2,3,1};
        int[] arr = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        System.out.println("Max robbery money is: " + robbingDP(arr, arr.length - 1));
    }

    private static int robbingDP(int[] arr, int index) {
        if (index == 0) return arr[0];
        if (index == 1) return Math.max(arr[0], arr[1]);
        if (!robberySum.containsKey(index))
            robberySum.put(index, Math.max(robbingDP(arr, index - 1), robbingDP(arr, index - 2) + arr[index]));
        return robberySum.get(index);
    }
}
