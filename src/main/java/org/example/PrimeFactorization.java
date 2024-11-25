package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public List<int[]> primeFactor(int n) {
        // return : list of pairs of prime numbers and frequency of this number
        List<int[]> primes = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n /= i;
                    count++; // Frequency
                }
                primes.add(new int[]{i, count});
            }
        }

        // If there's any prime factor left it's a prime number
        if (n > 1) {
            primes.add(new int[]{n, 1});
        }

        return primes;
    }
}

