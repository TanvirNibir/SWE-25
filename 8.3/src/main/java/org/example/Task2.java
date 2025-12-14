package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        System.out.println("Original list: " + numbers);
        System.out.println();

        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After filtering out even numbers: " + numbers);
        System.out.println();

        numbers.replaceAll(n -> n * 2);
        System.out.println("After doubling odd numbers: " + numbers);
        System.out.println();

        final int[] sum = {0};
        numbers.forEach(n -> sum[0] += n);
        System.out.println("Sum of all numbers: " + sum[0]);
        System.out.println();

        System.out.println("=== Complete Workflow Demonstration ===");
        List<Integer> originalNumbers = new ArrayList<>();
        originalNumbers.add(10);
        originalNumbers.add(5);
        originalNumbers.add(8);
        originalNumbers.add(20);
        originalNumbers.add(15);
        originalNumbers.add(3);
        originalNumbers.add(12);

        System.out.println("Step 1 - Original list: " + originalNumbers);

        List<Integer> filteredNumbers = new ArrayList<>(originalNumbers);
        filteredNumbers.removeIf(n -> n % 2 == 0);
        System.out.println("Step 2 - After filtering even numbers: " + filteredNumbers);

        filteredNumbers.replaceAll(n -> n * 2);
        System.out.println("Step 3 - After doubling: " + filteredNumbers);

        final int[] totalSum = {0};
        filteredNumbers.forEach(n -> totalSum[0] += n);
        System.out.println("Step 4 - Sum: " + totalSum[0]);
    }
}
