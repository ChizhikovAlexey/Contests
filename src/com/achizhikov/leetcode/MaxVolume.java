package com.achizhikov.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxVolume {
    public int maxArea(int[] height) {
        int maxLength = height.length;
        int max1 = Arrays.stream(height).max().getAsInt();
        int maxVolume = 0;
        for (int i = 0; i < maxLength - 1 && (maxLength - i) * max1 > maxVolume; i++) {
            for (int j = maxLength - 1; j > i && (j - i) * max1 > maxVolume; j--) {
                int volume = (j - i) * Math.min(height[i], height[j]);
                if (volume > maxVolume) {
                    maxVolume = volume;
                }
            }
        }
        return maxVolume;
    }
}
