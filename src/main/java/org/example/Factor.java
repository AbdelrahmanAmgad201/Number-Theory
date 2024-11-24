package org.example;

import java.util.List;

public class Factor {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            return gcd(b % a, a);
        }
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int gcdWithFactorization(int a, int b) {
        PrimeFactorization pf = new PrimeFactorization();
        List<int[]> factorsOfA = pf.primeFactor(a);
        List<int[]> factorsOfB = pf.primeFactor(b);
        int gcdResult = 1;

        int pointerA = 0;
        int pointerB = 0;

        // Compare prime factors of both numbers
        while (pointerA < factorsOfA.size() && pointerB < factorsOfB.size()) {
            int primeA = factorsOfA.get(pointerA)[0];
            int primeB = factorsOfB.get(pointerB)[0];

            if (primeA == primeB) {
                // Common prime factor: take the minimum exponent
                int minExponent = Math.min(factorsOfA.get(pointerA)[1], factorsOfB.get(pointerB)[1]);
                gcdResult *= Math.pow(primeA, minExponent);
                pointerA++;
                pointerB++;
            } else if (primeA < primeB) {
                // Move pointer for the smaller prime factor
                pointerA++;
            } else {
                pointerB++;
            }
        }

        return gcdResult;
    }
}
