package Task3;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filename = "enrollments.ser";
        Enrollment enrollment;

        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
                enrollment = (Enrollment) in.readObject();
                System.out.println("Deserialized Enrollment:\n" + enrollment);
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            Student student = new Student(101, "Ahmad", 22);
            Course course = new Course("CS101", "Intro to Java", "Dr. Jarkko");
            enrollment = new Enrollment(student, course, "08.09.2025");

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(enrollment);
                System.out.println("Enrollment serialized to " + filename);
            } catch (IOException e) {
                System.err.println("Error writing file: " + e.getMessage());
            }
        }
    }
}