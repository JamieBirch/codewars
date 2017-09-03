package com.github.jamie_birch;

import java.util.Arrays;

public class SpinWords {

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
    }

    public static String spinWords(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            if (word.length() >= 5) {
                sb.append(revert(word) + " ");
            } else sb.append(word + " ");
        }

        return sb.toString().trim();
    }

    private static String revert(String word) {
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();
        for(int i = letters.length-1; i >= 0; i--){
            sb.append(letters[i]);
        }
        return sb.toString();
    }
}
