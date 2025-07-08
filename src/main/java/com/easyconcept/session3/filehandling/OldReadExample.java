package com.easyconcept.session3.filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class OldReadExample {
    // This is not efficient
    public static void read(){
        try{
            FileReader reader = new FileReader("student.txt");
            int character;

            while((character = reader.read()) != -1){
                System.out.println((char) character);
            }
            reader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            // permission issue - no permission to read the file
            // file deleted
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }

    public static void readNew() {
        try {
            File file = new File("student.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
