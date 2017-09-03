package com.github.jamie_birch;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class DirReductionStack {

    public static void main(String[] args) {

        String[] dirs = { "NORTH", "WEST", "SOUTH", "EAST" };

        System.out.println(Arrays.toString(dirReduc(dirs)));

    }

    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String dir : arr) {
            if (!stack.isEmpty() && Objects.equals(stack.peek(), getOpposite(dir))) {
                stack.pop();
            } else stack.push(dir);
            System.out.println(stack);
        }

        Object[] resultObj = stack.toArray();
        String[] result = new String[resultObj.length];

        for(int i = 0; i < resultObj.length; i++){
            result[i] = resultObj[i].toString();
        }

        return result;
    }

    private static String getOpposite(String dir){
        if(dir.equals("NORTH")) return "SOUTH";
        if(dir.equals("SOUTH")) return "NORTH";
        if(dir.equals("EAST")) return "WEST";
        if(dir.equals("WEST")) return "EAST";
        return "direction unknown";
    }
}
