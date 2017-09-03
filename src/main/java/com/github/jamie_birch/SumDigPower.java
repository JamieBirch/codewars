package com.github.jamie_birch;

import java.util.ArrayList;
import java.util.List;

/**
 * Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
 * The number 89 is the first integer with more than one digit that fulfills the property partially introduced
 * in the title of this kata. What's the use of saying "Eureka"? Because this sum gives the same number.
 *
 * In effect: 89 = 8^1 + 9^2
 *
 * The next number in having this property is 135.
 *
 * See this property again: 135 = 1^1 + 3^2 + 5^3
 *
 * We need a function to collect these numbers, that may receive two integers a, b that defines the range [a, b] (inclusive)
 * and outputs a list of the sorted numbers in the range that fulfills the property described above.
 */


public class SumDigPower {

    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 100));
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();

        for(long i = a; i <= b; i++){
            if(fits(i)) result.add(i);
        }

        return result;
    }

    private static boolean fits(long n) {
        int digits = countDigits(n);
        long sum = 0;
        long number = n;
        for(int i = 1, pow = digits; pow > 0; i++, pow-- ){
            long a = number/(int)(Math.pow(10,pow-1));
            long r = number%(int)(Math.pow(10,pow-1));
            number = r;
            sum+=(int)(Math.pow(a,i));
        }
        return (sum == n);
    }

    private static int countDigits(long n) {
        long r = n;
        int count = 0;
        while(r >= 1){
            r/=10;
            count+=1;
        }
        return count;
    }


}
