package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        GcdAndLcm factorer = new GcdAndLcm();
        int a = 36;
        int b = 4;
        System.out.println(factorer.gcd(a,b));
        System.out.println(factorer.gcdWithFactorization(a,b));
        System.out.println(factorer.lcm(a,b));

        PrimeFactorization pf = new PrimeFactorization();
        int n = 56;
        List<int[]> factors = pf.primeFactor(n);

        System.out.println("Prime factors of " + n + ":");
        for (int[] factor : factors) {
            System.out.println("Prime: " + factor[0] + ", Exponent: " + factor[1]);
        }
        PrimeChecker check = new PrimeChecker();
        System.out.println(check.isPrime(7));

    }
}