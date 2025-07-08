package com.easyconcept.session1.solution1.ui;

import com.easyconcept.session1.solution1.dto.StudentDto;
import com.easyconcept.session1.solution1.entity.Student;
import com.easyconcept.session1.solution1.service.StudentService;
import com.easyconcept.session1.solution1.serviceImpl.StudentServiceImpl;

import java.util.*;

public class MyUIManager {
    private final StudentService service = new StudentServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void launch() {
        while (true) {
            System.out.println("\n====== Student Record System ======");
            System.out.println("1. Register a student");
            System.out.println("2. View all students");
            System.out.println("3. Find student by name");
            System.out.println("4. Edit student age");
            System.out.println("5. Delete student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> showAllStudents();
                case 3 -> findStudentByName();
                case 4 -> updateStudentAge();
                case 5 -> deleteStudent();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void registerStudent() {
        StudentDto dto = new StudentDto();
        System.out.print("Enter student name: ");
        dto.name = scanner.nextLine();

        System.out.print("Enter student age: ");
        dto.age = scanner.nextInt();
        scanner.nextLine();

        System.out.println(service.createStudent(dto).message);
    }

    private void showAllStudents() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge());
            }
        }
    }

    private void findStudentByName() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = service.getStudentByName(name);
        if (student != null) {
            System.out.println("Student Found: " + student.getId() + " | " + student.getName() + " | " + student.getAge());
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudentAge() {
        System.out.print("Enter student ID to update: ");
        UUID id = UUID.fromString(scanner.nextLine());

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println(service.updateStudentAge(id, age).message);
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        UUID id = UUID.fromString(scanner.nextLine());
        System.out.println(service.deleteStudent(id).message);
    }
}
