package com.achizhikov.leetcode;

import java.util.Arrays;

public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2 && closestSum != target; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) continue;

            int j = i + 1;

            int k = nums.length - 1;

            while (j < k && closestSum != target) {
                int b = nums[j];
                int c = nums[k];
                int currentSum = a + b + c;
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                if (currentSum < target) {
                    j++;
                } else if (currentSum > target) {
                    k--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSumClosest(new int[] {1,1,-1,-1,3}, 1));
    }
}
