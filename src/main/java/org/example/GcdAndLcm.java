package org.example;

import java.util.List;

public class GcdAndLcm {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b; // Our base case
        } else {
            return gcd(b % a, a); // Using Euclidean property
        }
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b); // Using the property of gcd and lcm
    }

    public int gcdWithFactorization(int a, int b) {
        // Factorize a and b to their prime factors
        PrimeFactorization pf = new PrimeFactorization();
        List<int[]> factorsOfA = pf.primeFactor(a);
        List<int[]> factorsOfB = pf.primeFactor(b);
        int gcdResult = 1; // To store our result

        // Pointers to compare with
        int pointerA = 0;
        int pointerB = 0;

        // Compare prime factors of both numbers
        while (pointerA < factorsOfA.size() && pointerB < factorsOfB.size()) {
            int primeA = factorsOfA.get(pointerA)[0];
            int primeB = factorsOfB.get(pointerB)[0];

            if (primeA == primeB) {
                // take the minimum exponent of prime factor
                int minExponent = Math.min(factorsOfA.get(pointerA)[1], factorsOfB.get(pointerB)[1]);
                gcdResult *= (int) Math.pow(primeA, minExponent);
                pointerA++;
                pointerB++;
            } else if (primeA < primeB) {
                pointerA++;
            } else {
                pointerB++;
            }
        }
        return gcdResult;
    }
}
