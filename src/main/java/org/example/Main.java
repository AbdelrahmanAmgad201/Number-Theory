package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws GcdAndLcm.InvalidInputException {
        int a = 0;
        int b = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first integer: ");
            a = validateIntegerInput(scanner.nextLine());

            System.out.print("Enter the second integer: ");
            b = validateIntegerInput(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. Please enter integers only.");
            System.exit(0);
        }

        // Testing GCD and LCM
        GcdAndLcm factorer = new GcdAndLcm();
        try {
            // Call the methods that may throw InvalidInputException
            System.out.println("GCD: " + factorer.gcd(a, b));
            System.out.println("GCD Using Factorization: " + factorer.gcdWithFactorization(a, b));
            System.out.println("LCM: " + factorer.lcm(a, b));
        } catch (GcdAndLcm.InvalidInputException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        PrimeFactorization pf = new PrimeFactorization();
        List<int[]> factorsOfA = pf.primeFactor(a);
        List<int[]> factorsOfB = pf.primeFactor(a);

        System.out.println("Prime factors of " + a + ":");
        for (int[] factor : factorsOfA) {
            System.out.println("Prime: " + factor[0] + ", Exponent: " + factor[1]);
        }
        System.out.println("Prime factors of " + b + ":");
        for (int[] factor : factorsOfB) {
            System.out.println("Prime: " + factor[0] + ", Exponent: " + factor[1]);
        }
        PrimeChecker check = new PrimeChecker();
        System.out.println("is" + a + "prime: " + check.isPrime(a));
        System.out.println("is" + b + "prime: " + check.isPrime(b));

    }

    private static int validateIntegerInput(String input) throws NumberFormatException {
        return Integer.parseInt(input); // Throws NumberFormatException if the input is not a valid integer
    }
}