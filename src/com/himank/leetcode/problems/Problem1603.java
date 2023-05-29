package com.himank.leetcode.problems;

public class Problem1603 {

    public static void main(String[] args) {
        Problem1603 parkingSystem = new Problem1603(1, 1, 0);
        assert parkingSystem.addCar(1);
        assert parkingSystem.addCar(2);
        assert !parkingSystem.addCar(3);
        assert !parkingSystem.addCar(1);
        System.out.println("All assert passed.");
    }

    int[] slotsCount;

    public Problem1603(int big, int medium, int small) {
        slotsCount = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (slotsCount[carType - 1] > 0) {
            slotsCount[carType - 1]--;
            return true;
        }
        return false;
    }
}
