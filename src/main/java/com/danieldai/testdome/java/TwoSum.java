package com.danieldai.testdome.java;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            if (nums.containsKey(sum - list[i])) {
                return new int[]{nums.get(sum - list[i]), i};
            } else {
                nums.put(list[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}