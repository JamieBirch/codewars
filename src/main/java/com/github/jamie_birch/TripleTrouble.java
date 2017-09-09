package com.github.jamie_birch;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Write a function which takes in numbers num1 and num2 and
 * returns 1 if there is a straight triple of a number at any place in num1
 * and also a straight double of the same number in num2.
 */

public class TripleTrouble {

    public static void main(String[] args) {
        System.out.println(TripleDouble(451999277L, 41177722899L));
    }

    public static int TripleDouble(long num1, long num2) {
        Optional<Integer> triple = slidingWindow(3, num1)
                .filter(numbers -> numbers.stream().distinct().count() == 1)
                .findFirst()
                .map(numbers -> numbers.get(0));

        Optional<Integer> trouble = triple.flatMap(number ->
                slidingWindow(2, num2)
                        .filter(numbers -> numbers.stream().distinct().count() == 1)
                        .map(numbers -> numbers.get(0))
                        .filter(troubleNumber -> troubleNumber.equals(number))
                        .findFirst()
        );

        return trouble.isPresent() ? 1 : 0;
    }

    private static Stream<List<Integer>> slidingWindow(int size, Long num) {
        final String sNum = num.toString();
        return IntStream.range(0, sNum.length() - size + 1)
                .mapToObj(index -> numToList(sNum.substring(index, index + size)));
    }

    private static List<Integer> numToList(String sNum) {
        return sNum.chars()
                   .map(Character::getNumericValue)
                   .boxed()
                   .collect(Collectors.toList());
    }
}
