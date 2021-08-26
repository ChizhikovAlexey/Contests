package com.achizhikov.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);
        doSum(candidates, target, result, temp, 0, 0);
        return result;
    }

    private void doSum(
            int[] candidates,
            int target,
            List<List<Integer>> result,
            List<Integer> temp,
            int sum,
            int start) {
        if (sum == target)
            result.add(new ArrayList<>(temp));
        if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                sum += candidates[i];
                if (sum > target) {
                    break;
                } else {
                    temp.add(candidates[i]);
                    doSum(candidates, target, result, temp, sum, i);
                    temp.remove(temp.size() - 1);
                    sum -= candidates[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new CombinationSum().combinationSum(new int[]{1, 2, 3, 4}, 4));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
