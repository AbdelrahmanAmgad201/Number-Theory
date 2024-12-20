package org.example;

import java.util.List;

import static java.lang.Math.max;

public class GcdAndLcm {

    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public int gcd(int a, int b) throws InvalidInputException {
        if (a == 0 && b == 0) {
            throw new InvalidInputException("GCD of 0 and 0 is undefined.");
        }
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0) {
            return b; // Base case: gcd(0, b) = b
        }else {
            return gcd(b % a, a); // Recursive call using Euclidean algorithm
        }
    }


    public int lcm(int a, int b) throws InvalidInputException {
        if (a == 0 || b == 0) {
            throw new InvalidInputException("LCM of 0 and 0 is undefined.");
        }
        return Math.abs(a * b) / gcd(a, b); // Using the relationship between GCD and LCM
    }

    public int gcdWithFactorization(int a, int b) {
        // Factorize a and b to their prime factors
        PrimeFactorization pf = new PrimeFactorization();
        List<int[]> factorsOfA = pf.primeFactor(a);
        List<int[]> factorsOfB = pf.primeFactor(b);
        int gcdResult = 1; // To store our result
        if(a == 0 || b == 0){
            return max(a , b);
        }
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
    public int lcmWithFactorization(int a, int b) {
        // Factorize a and b to their prime factors
        PrimeFactorization pf = new PrimeFactorization();
        List<int[]> factorsOfA = pf.primeFactor(a);
        List<int[]> factorsOfB = pf.primeFactor(b);
        int lcmResult = 1; // To store our result
        if (a == 0 || b == 0) {
            return 0; // LCM of 0 and any number is 0
        }

        // Pointers to compare with
        int pointerA = 0;
        int pointerB = 0;

        // Compare prime factors of both numbers
        while (pointerA < factorsOfA.size() || pointerB < factorsOfB.size()) {
            if (pointerA < factorsOfA.size() && (pointerB >= factorsOfB.size() || factorsOfA.get(pointerA)[0] < factorsOfB.get(pointerB)[0])) {
                int primeA = factorsOfA.get(pointerA)[0];
                int exponentA = factorsOfA.get(pointerA)[1];
                lcmResult *= (int) Math.pow(primeA, exponentA);
                pointerA++;
            } else if (pointerA >= factorsOfA.size() || factorsOfB.get(pointerB)[0] < factorsOfA.get(pointerA)[0]) {
                int primeB = factorsOfB.get(pointerB)[0];
                int exponentB = factorsOfB.get(pointerB)[1];
                lcmResult *= (int) Math.pow(primeB, exponentB);
                pointerB++;
            } else {
                int prime = factorsOfA.get(pointerA)[0];
                int maxExponent = Math.max(factorsOfA.get(pointerA)[1], factorsOfB.get(pointerB)[1]);
                lcmResult *= (int) Math.pow(prime, maxExponent);
                pointerA++;
                pointerB++;
            }
        }
        if (lcmResult < 0) {
            throw new ArithmeticException("Overflow occurred while calculating LCM");
        }

        return lcmResult;
    }

}
