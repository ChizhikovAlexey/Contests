package com.achizhikov.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        combine(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void combine(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    temp.add(nums[i]);
                    used[i] = true;
                    combine(nums, result, temp, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}