package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28, "New York"));
        people.add(new Person("Bob", 35, "Los Angeles"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("Diana", 45, "Chicago"));
        people.add(new Person("Eve", 31, "New York"));
        people.add(new Person("Frank", 29, "Los Angeles"));
        people.add(new Person("Grace", 38, "New York"));
        people.add(new Person("Henry", 25, "Chicago"));

        System.out.println("Original list:");
        people.forEach(person -> System.out.println(person));
        System.out.println();

        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        System.out.println("Sorted by age (ascending):");
        people.forEach(person -> System.out.println(person));
        System.out.println();

        String targetCity = "New York";
        people.removeIf(person -> !person.getCity().equals(targetCity));

        System.out.println("Filtered list (only " + targetCity + "):");
        people.forEach(person -> System.out.println(person));
        System.out.println();

        System.out.println("Additional examples:");
        
        List<Person> peopleByName = new ArrayList<>(people);
        peopleByName.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println("Sorted by name:");
        peopleByName.forEach(person -> System.out.println(person));
    }
}
