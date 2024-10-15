package com.danieldai.testdome.java;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if ( sortedArray.length == 0) {
            return 0;
        }
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(sortedArray[mid] == lessThan) {
                return mid;
            }
            if (sortedArray[mid] <= lessThan) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 4, 5, 7 }, 4));
    }
}