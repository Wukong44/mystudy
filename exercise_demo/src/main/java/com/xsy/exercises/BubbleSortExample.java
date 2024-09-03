package com.xsy.exercises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

// 冒泡排序
public class BubbleSortExample {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = false; // 该轮是否排序过
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果这一轮没有发生任何交换，则说明数组已经排序好了
            if (!swapped) {
                break;
            }
        }
    }
}
