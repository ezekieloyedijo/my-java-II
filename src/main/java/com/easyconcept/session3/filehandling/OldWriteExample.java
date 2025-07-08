package com.easyconcept.session3.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OldWriteExample {
    public void write() {
    try(FileWriter writer = new FileWriter("./src/student.txt", true)){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        writer.write(text);
        scanner.close();
    } catch(IOException e) {
        e.printStackTrace();
    }
    }
}
