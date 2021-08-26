package com.achizhikov.leetcode;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] cache = new int[k];
        System.arraycopy(nums, nums.length - k, cache, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(cache, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};

        long start = System.currentTimeMillis();
        new RotateArray().rotate(array, 3);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));

        System.out.println(end - start + "ms");
    }
}
