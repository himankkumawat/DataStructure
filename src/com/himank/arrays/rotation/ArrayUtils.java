package com.himank.arrays.rotation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayUtils {

    public static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] readArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in array.");
        int no = sc.nextInt();
        int[] arr = new int[no];

        System.out.println("Enter the elements of array.");
//        Arrays.stream(arr).forEach(a -> a = sc.nextInt());
        for (int i=0; i<no;i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }
}
