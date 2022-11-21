package com.himank.arrays.rotation;

import java.util.Scanner;

public class ArrayRotation1 {

    public static void main(String[] args) {

        int[] arr = ArrayUtils.readArray();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements to be rotated.");
        int rotation = sc.nextInt();
        rotation1(arr, rotation);
        System.out.println("Output: ");
        ArrayUtils.printArray(arr);

    }

    public static void rotation1(int[] arr, int rotation) {
        int n = arr.length;
        int[] temp = new int[n];
        int k = 0;
        for (int i = rotation; i < n; i++) {
            temp[k++] = arr[i];
        }
        for (int i = 0; i < rotation; i++) {
            temp[k++] = arr[i];
        }
        System.arraycopy(temp, 0, arr, 0, n);
    }
}
