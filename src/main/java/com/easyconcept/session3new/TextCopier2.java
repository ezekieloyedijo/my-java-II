package com.easyconcept.session3new;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextCopier2 {
    private List<String> typedLines;

    // Read user input using Scanner and store in memory
    public void copyFromUserInput() {
        typedLines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text line by line (type 'exit' to finish):");

        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) break;
            typedLines.add(line);
        }

        System.out.println("Input captured successfully.");
    }

    // Paste the typed input into a file
    public void pasteToFile(Path destinationPath) {
        if (typedLines == null || typedLines.isEmpty()) {
            System.out.println("Nothing to paste. Please enter some text first.");
            return;
        }

        try {
            // Ensure the folder exists
            Path parentDir = destinationPath.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            // Write to the file
            try (BufferedWriter writer = Files.newBufferedWriter(destinationPath)) {
                for (String line : typedLines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Text saved to file: " + destinationPath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        TextCopier2 copier = new TextCopier2();
        Scanner input = new Scanner(System.in);

        copier.copyFromUserInput();  // Step 1: Read from Scanner

        System.out.print("Enter path to save the file (e.g., output.txt or src/output.txt): ");
        String destinationFilePath = input.nextLine();

        Path destination = Path.of(destinationFilePath);

        copier.pasteToFile(destination);  // Step 2: Write to file
    }
}
