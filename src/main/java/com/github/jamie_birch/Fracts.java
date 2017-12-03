package com.github.jamie_birch;

import java.util.HashSet;
import java.util.Set;

/**
 *  You will have a list of rationals in the form
 *  { {numer_1, denom_1} , ... {numer_n, denom_n} }
 *  where all numbers are positive ints.
 *  You have to produce a result in the form
 *  (N_1, D) ... (N_n, D)
 *  in which D is as small as possible and
 *  N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
 *
 *  Example:
 *  convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
 */

public class Fracts {

    public static void main(String[] args) {
        long[][] lst;
        lst = new long[][] { {1, 2}, {1, 3}, {1, 4} };
        System.out.println(convertFrac(lst));
    }

    public static String convertFrac(long[][] lst) {

        Set<Long> denominators = new HashSet<>();

        for (long[] aLst : lst) {
            denominators.add(aLst[1]);
        }

        long lcm = lcmOfThree(denominators);

        long[][] result = new long[lst.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = lcm * lst[i][0] / lst[i][1];
            result[i][1] = lcm;
        }

        return resultToString(result);
    }

    private static String resultToString(long[][] result) {
        StringBuilder sb = new StringBuilder();
        for (long[] aResult : result) {
            sb.append("(" + aResult[0] + "," + aResult[1] + ")");
        }
        return sb.toString();
    }

    private static long lcmOfThree(Set<Long> denominators) {
        return denominators
                .stream()
                .reduce((a, b) -> lcm(a, b))
                .orElse(1L);
    }

    private static long lcm(long a, long b){
        return a / gcd(a, b) * b;
    }

    private static long gcd(long a, long b){
        return b==0 ? a : gcd(b, a % b);
    }
}
