package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeChecker {
    public boolean isPrime(int num) {
        // Calculate the sieve for numbers up to num
        if(num <= 1){
            return false;
        }
        List<Integer> primes = sieveOfEratosthenes(num);
        // Check if the number is in the list of primes
        return primes.contains(num);
    }
    private List<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array initialized to true
        if (n < 0) {
            return new ArrayList<>();
        }

        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        // Sieve of Eratosthenes algorithm
        for (int p = 2; p * p <= n; p++) { // loop till root(n)
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false; // Mark multiples of the prime as false
                }
            }
        }

        // Add all prime numbers to the list to return
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
