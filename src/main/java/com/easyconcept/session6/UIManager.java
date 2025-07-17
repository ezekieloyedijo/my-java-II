package com.easyconcept.session6;

// Here we expose the StudentServiceImpl

import java.util.Scanner;

public class UIManager {
    private final StudentServiceImpl studentService = new StudentServiceImpl();
    Scanner scanner = new Scanner(System.in);
    public void launch(){
        try{
            System.out.println("Welcome to our sample application!");
            System.out.println("Enter 1 to create student");
            System.out.println("Enter 4 to exit");
            System.out.print("Enter your option: ");
            int choice = scanner.nextInt();

            boolean isProgramRunning = true;

            while(isProgramRunning) {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 4:
                        isProgramRunning = false;
                        System.out.println("Session ended!!!");
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addStudent(){
        scanner.nextLine();
        try{
              System.out.println("Enter Student name: ");
              String name = scanner.nextLine();

              System.out.println("Enter Password: ");
              String password = scanner.nextLine();

              System.out.println("Enter age: ");
              int age = scanner.nextInt();

              System.out.println("Enter gender: ");
              scanner.nextLine();
              String input = scanner.nextLine().toUpperCase(); // Convert input to uppercase
              Gender gender = Gender.valueOf(input); // Convert string to enum

             StudentDto studentDto = new StudentDto(name, password, age, gender);
             studentService.addStudent(studentDto);

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid gender. Please enter 'MALE' or 'FEMALE'.");
        } finally {
            scanner.close();
        }
    }
}
