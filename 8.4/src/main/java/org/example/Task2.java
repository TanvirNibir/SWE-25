package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Task 2: Filter even numbers, double remaining, and sum using functional programming.
 */
public class Task2 {
    
    /**
     * Filters out even numbers, doubles the remaining (odd) numbers, and returns their sum.
     * 
     * @param numbers list of integers (must not be null)
     * @return sum of doubled odd numbers, or 0 if no odd numbers exist
     */
    public static int processNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        
        return numbers.stream()
                .filter(n -> n % 2 != 0)  // Keep only odd numbers
                .mapToInt(n -> n * 2)      // Double each number
                .sum();                     // Sum all numbers
    }
    
    /**
     * Alternative implementation using explicit reduce.
     * 
     * @param numbers list of integers (must not be null)
     * @return sum of doubled odd numbers, or 0 if no odd numbers exist
     */
    public static int processNumbersWithReduce(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        
        return numbers.stream()
                .filter(n -> n % 2 != 0)           // Keep only odd numbers
                .map(n -> n * 2)                   // Double each number
                .reduce(0, Integer::sum);          // Sum with initial value 0
    }
    
    /**
     * Returns the filtered and doubled numbers for demonstration.
     * 
     * @param numbers list of integers (must not be null)
     * @return list of doubled odd numbers
     */
    public static List<Integer> getFilteredAndDoubled(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        
        return numbers.stream()
                .filter(n -> n % 2 != 0)  // Keep only odd numbers
                .map(n -> n * 2)           // Double each number
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test case 1: mixed numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original list: " + numbers1);
        
        List<Integer> filteredAndDoubled = getFilteredAndDoubled(numbers1);
        System.out.println("After filtering (odd only) and doubling: " + filteredAndDoubled);
        
        int sum1 = processNumbers(numbers1);
        System.out.println("Sum of doubled odd numbers: " + sum1);
        System.out.println("Verification: " + filteredAndDoubled + " = " + 
            filteredAndDoubled.stream().mapToInt(Integer::intValue).sum());
        System.out.println();
        
        // Test case 2: all even numbers
        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8, 10);
        System.out.println("Original list: " + numbers2);
        int sum2 = processNumbers(numbers2);
        System.out.println("Sum of doubled odd numbers: " + sum2 + " (no odd numbers)");
        System.out.println();
        
        // Test case 3: all odd numbers
        List<Integer> numbers3 = Arrays.asList(1, 3, 5, 7, 9);
        System.out.println("Original list: " + numbers3);
        List<Integer> transformed3 = getFilteredAndDoubled(numbers3);
        System.out.println("After filtering (odd only) and doubling: " + transformed3);
        int sum3 = processNumbers(numbers3);
        System.out.println("Sum of doubled odd numbers: " + sum3);
        System.out.println();
        
        // Test case 4: single element
        List<Integer> numbers4 = Arrays.asList(5);
        System.out.println("Original list: " + numbers4);
        int sum4 = processNumbers(numbers4);
        System.out.println("Sum of doubled odd numbers: " + sum4);
        System.out.println();
        
        // Test case 5: empty list
        List<Integer> numbers5 = Arrays.asList();
        System.out.println("Original list: " + numbers5);
        int sum5 = processNumbers(numbers5);
        System.out.println("Sum of doubled odd numbers: " + sum5);
        System.out.println();
        
        // Test case 6: negative numbers
        List<Integer> numbers6 = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3);
        System.out.println("Original list: " + numbers6);
        List<Integer> transformed6 = getFilteredAndDoubled(numbers6);
        System.out.println("After filtering (odd only) and doubling: " + transformed6);
        int sum6 = processNumbers(numbers6);
        System.out.println("Sum of doubled odd numbers: " + sum6);
        System.out.println();
        
        // Alternative implementation
        System.out.println("Alternative implementation using explicit reduce:");
        System.out.println("Result: " + processNumbersWithReduce(numbers1));
    }
}

