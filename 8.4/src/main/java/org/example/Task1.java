package org.example;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Task 1: Calculate mean of an array using functional programming (no for-loops).
 */
public class Task1 {
    
    /**
     * Calculates the mean of an array using streams.
     * 
     * @param numbers array of integers (must not be null)
     * @return OptionalDouble containing the mean, or empty if array is empty
     */
    public static OptionalDouble calculateMean(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        return Arrays.stream(numbers)
                .average();
    }
    
    /**
     * Alternative implementation using reduce.
     * 
     * @param numbers array of integers (must not be null)
     * @return OptionalDouble containing the mean, or empty if array is empty
     */
    public static OptionalDouble calculateMeanWithReduce(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        if (numbers.length == 0) {
            return OptionalDouble.empty();
        }
        
        int sum = Arrays.stream(numbers)
                .reduce(0, Integer::sum);
        
        return OptionalDouble.of((double) sum / numbers.length);
    }
    
    /**
     * Calculates the mean using mapToDouble.
     * 
     * @param numbers array of integers (must not be null)
     * @return OptionalDouble containing the mean, or empty if array is empty
     */
    public static OptionalDouble calculateMeanWithMapToDouble(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        return Arrays.stream(numbers)
                .mapToDouble(n -> (double) n)
                .average();
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] numbers1 = {10, 20, 30, 40, 50};
        OptionalDouble mean1 = calculateMean(numbers1);
        System.out.println("Array: " + Arrays.toString(numbers1));
        System.out.println("Mean: " + (mean1.isPresent() ? mean1.getAsDouble() : "N/A"));
        System.out.println();
        
        // Test case 2: negative numbers
        int[] numbers2 = {-5, 0, 5, 10, 15};
        OptionalDouble mean2 = calculateMean(numbers2);
        System.out.println("Array: " + Arrays.toString(numbers2));
        System.out.println("Mean: " + (mean2.isPresent() ? mean2.getAsDouble() : "N/A"));
        System.out.println();
        
        // Test case 3: single element
        int[] numbers3 = {42};
        OptionalDouble mean3 = calculateMean(numbers3);
        System.out.println("Array: " + Arrays.toString(numbers3));
        System.out.println("Mean: " + (mean3.isPresent() ? mean3.getAsDouble() : "N/A"));
        System.out.println();
        
        // Test case 4: empty array
        int[] numbers4 = {};
        OptionalDouble mean4 = calculateMean(numbers4);
        System.out.println("Array: " + Arrays.toString(numbers4));
        System.out.println("Mean: " + (mean4.isPresent() ? mean4.getAsDouble() : "N/A (empty array)"));
        System.out.println();
        
        // Alternative implementations
        System.out.println("Alternative implementations:");
        System.out.println("Using reduce: " + 
            (calculateMeanWithReduce(numbers1).isPresent() 
                ? calculateMeanWithReduce(numbers1).getAsDouble() 
                : "N/A"));
        System.out.println("Using mapToDouble: " + 
            (calculateMeanWithMapToDouble(numbers1).isPresent() 
                ? calculateMeanWithMapToDouble(numbers1).getAsDouble() 
                : "N/A"));
    }
}

