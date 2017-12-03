package com.github.jamie_birch;

/**
 * You are going to be given an array of integers.
 * Your job is to take that array and find an index N where the sum
 * of the integers to the left of N is equal to the sum
 * of the integers to the right of N.
 * If there is no index that would make this happen, return -1.
 *
 * For example:
 * Let's say you are given the array {1,2,3,4,3,2,1}:
 * Your function will return the index 3
 */

public class ArraySides {

    public static void main(String[] args) {
        int[] arr = new int[] {20,10,-80,10,10,15,35};
        System.out.println(findEvenIndex(arr));
    }

    public static int findEvenIndex(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(sum(arr, 0, i) == sum(arr, i+1, arr.length)){
                return i;
            }
        }
        return -1;
    }

    private static int sum(int[] arr, int from, int to) {
        int sum = 0;
        for(int i = from; i < to; i++){
            sum += arr[i];
        }
        return sum;
    }
}
