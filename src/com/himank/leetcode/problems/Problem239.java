package com.himank.leetcode.problems;

import java.util.*;

public class Problem239 {

    // https://leetcode.com/problems/sliding-window-maximum/description/
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] answer = maxSlidingWindow(nums, 3);
        System.out.println("Maximum value in sliding window : ");
        Arrays.stream(answer).forEach(x -> System.out.print(x + "  "));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
