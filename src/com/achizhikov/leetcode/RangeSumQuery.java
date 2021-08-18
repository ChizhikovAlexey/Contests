package com.achizhikov.leetcode;

class NumArray {

    private final int[] arr;
    private int[] cache;
    private final int step;

    public NumArray(int[] nums) {
        arr = nums;
        if (arr.length > 1000) {
            cache = new int[100];
            step = nums.length / 100;
            for (int i = 0; i < 100; i++) {
                cache[i] = 0;
                for (int j = step * i; j < step * (i + 1); j++) {
                    cache[i] += arr[j];
                }
            }
        } else {
            step = 0;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        if (step == 0) {
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
        } else {
            int first = left + step - left % step;
            int last = right - left % step;
            for (int i = left; i < Math.min(right, first * step); i++) {
                sum += arr[i];
            }
            for (int i = last * step + 1; i <= right; i++) {
                sum += arr[i];
            }
            for (int i = first; i <= last; i++) {
                sum += cache[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int length = 30000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = 1;
        }
        NumArray numArray = new NumArray(arr);
        System.out.println(numArray.sumRange(7, 92));
    }
}
