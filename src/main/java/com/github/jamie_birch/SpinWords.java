package com.github.jamie_birch;

/**
 * Write a function that takes in a string of one or more words,
 * and returns the same string, but with all five or more letter words reversed
 * Strings passed in will consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 *
 * Examples:
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 */

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
