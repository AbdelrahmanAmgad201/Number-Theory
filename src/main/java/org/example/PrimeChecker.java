package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeChecker {
    public boolean isPrime(int num) {
        // Calculate the sieve for numbers up to 'num'
        List<Integer> primes = sieveOfEratosthenes(num);
        // Check if the number is in the list of primes
        return primes.contains(num);
    }
    private List<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize all entries as true.
        boolean[] prime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();

        // Initialize all numbers as prime (true)
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        // Sieve of Eratosthenes algorithm
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) { // If prime[p] is not changed, it is a prime
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false; // Mark multiples of p as false
                }
            }
        }

        // Add all prime numbers to the list
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
