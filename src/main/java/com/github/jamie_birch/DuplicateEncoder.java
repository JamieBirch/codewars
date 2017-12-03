package com.github.jamie_birch;

/**
 *The goal of this exercise is to convert a string to a new string
 * where each character in the new string
 * is '(' if that character appears only once in the original string,
 * or ')' if that character appears more than once in the original string.
 * Ignore capitalization when determining if a character is a duplicate.
 *
 * Examples:
 * "din" => "((("
 * "recede" => "()()()"
 * "Success" => ")())())"
 * "(( @" => "))(("
 */

public class DuplicateEncoder {

    public static void main(String[] args) {
        System.out.println(encode("(( @"));
    }

    static String encode(String word){
        StringBuilder sb = new StringBuilder();
        char[] chars = word.toLowerCase().toCharArray();
        for(int i = 0; i < chars.length; i++){
            for (int j = 0; j < chars.length; j++){
                if(chars[i] == chars[j] && i!=j){
                    sb.append(")");
                    break;
                }
                if(j == word.length() - 1){
                    sb.append("(");
                }
            }
        }
        word = sb.toString();
        return word;
    }
}
