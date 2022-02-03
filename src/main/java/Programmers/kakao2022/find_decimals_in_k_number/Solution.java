package Programmers.kakao2022.find_decimals_in_k_number;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {

    public int solution(int n, int k) {
        BigInteger[] primes = Arrays.stream(Integer.toString(n, k).split("[0]+"))
                .map(BigInteger::new)
                .filter(bi -> bi.isProbablePrime(10))
                .toArray(BigInteger[]::new);
        return primes.length;
    }

}
