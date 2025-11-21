package Task3;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student: " + name + " (ID: " + id + ", Age: " + age + ")";
    }
}