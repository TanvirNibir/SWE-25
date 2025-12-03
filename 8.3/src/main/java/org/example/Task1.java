package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Task 1: Sorting and filtering using lambdas and Comparator (no Stream API).
 */
public class Task1 {

    public static void main(String[] args) {
        List<Person> people = createSamplePeople();

        System.out.println("=== Original list ===");
        printPeople(people);

        // Sort by age (ascending) using a lambda-based Comparator
        Comparator<Person> byAgeAscending =
                (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        people.sort(byAgeAscending);

        System.out.println("\n=== Sorted by age (ascending) ===");
        printPeople(people);

        // Filter by city using removeIf with a lambda (keep only people from targetCity)
        String targetCity = "New York";
        List<Person> fromTargetCity = new ArrayList<>(people);
        fromTargetCity.removeIf(person -> !targetCity.equals(person.getCity()));

        System.out.println("\n=== People from city: " + targetCity + " ===");
        printPeople(fromTargetCity);
    }

    private static List<Person> createSamplePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 22, "London"));
        people.add(new Person("Charlie", 28, "New York"));
        people.add(new Person("Diana", 35, "Berlin"));
        people.add(new Person("Eve", 27, "New York"));
        people.add(new Person("Frank", 40, "Paris"));
        return people;
    }

    private static void printPeople(List<Person> people) {
        people.forEach(person -> System.out.println(person));
    }

    /**
     * Simple immutable Person value object.
     */
    private static final class Person {
        private final String name;
        private final int age;
        private final String city;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
}


