package com.github.jamie_birch;

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
