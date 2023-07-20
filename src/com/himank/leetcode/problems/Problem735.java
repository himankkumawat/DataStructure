package com.himank.leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem735 {

    // https://leetcode.com/problems/asteroid-collision/description/
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        int[] remainingAsteroids = asteroidCollision(asteroids);
        Arrays.stream(remainingAsteroids).forEach(System.out::println);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }
                flag = false;
                break;
            }

            if (flag) {
                st.push(asteroid);
            }
        }

        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }

        return remainingAsteroids;
    }
}
