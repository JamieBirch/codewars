package com.github.jamie_birch;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 *The directions given to the man are, for example, the following:
 * { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
 * You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable,
 * better stay to the same place!
 * So the task is to give to the man a simplified version of the plan.
 * A better plan in this case is simply:
 * { "WEST" }
 */

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
