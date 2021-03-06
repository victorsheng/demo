package com.example.demo.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) throws Exception {
        int[] ints = {5, 3, 9, 1, 6, 7, 2, 4, 0, 8};
        int[] result = new QuickSort().sort(ints);
        System.out.println(Arrays.toString(result));
    }


    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            System.out.println(partitionIndex);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        // 坑位
        int index = pivot + 1;

        //遍历,从index开始
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                //跟pivot比较,但是跟index进行比较
                swap(arr, i, index);
                index++;
            }
        }
        //交换
        swap(arr, pivot, index - 1);
        //返回坑位
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        System.out.println("swap" + i + "----" + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}