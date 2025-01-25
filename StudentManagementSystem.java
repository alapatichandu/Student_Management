
import java.util.*;

public class StudentManagementSystem {
    private static HashMap<Integer, Student> studentRecords = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. View Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    updateStudent(scanner);
                    break;
                case 3:
                    removeStudent(scanner);
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    viewStudentById(scanner);
                    break;
                case 6:
                    System.out.println("Exiting Student Management System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentRecords.containsKey(id)) {
            System.out.println("Student with ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Student Grade: ");
        char grade = scanner.next().charAt(0);

        studentRecords.put(id, new Student(id, name, age, grade));
        System.out.println("Student added successfully!");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (!studentRecords.containsKey(id)) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }

        System.out.print("Enter Updated Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Updated Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Updated Grade: ");
        char grade = scanner.next().charAt(0);

        studentRecords.put(id, new Student(id, name, age, grade));
        System.out.println("Student updated successfully!");
    }

    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        if (studentRecords.remove(id) != null) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    private static void viewAllStudents() {
        if (studentRecords.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Student student : studentRecords.values()) {
            System.out.println(student);
        }
    }

    private static void viewStudentById(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = studentRecords.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private char grade;

    public Student(int id, String name, int age, char grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}