package com.easyconcept.session3new;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextCopier {
    private List<String> copiedContent;

    // Method to copy (read) the text file into memory
    public void copyFile(File sourceFile) {
        copiedContent = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                copiedContent.add(line);
            }
            System.out.println("File copied into memory.");
        } catch (IOException e) {
            System.out.println("Error reading the source file.");
            e.printStackTrace();
        }
    }

    // Method to paste (write) the text file from memory to destination
    public void pasteFile(File destinationFile) {
        if (copiedContent == null || copiedContent.isEmpty()) {
            System.out.println("Nothing to paste. Copy a file first.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            for (String line : copiedContent) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File written to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to the destination file.");
            e.printStackTrace();
        }
    }

    // Main method to demo
    public static void main(String[] args) {
        TextCopier copier = new TextCopier();

        File source = new File("classnote.txt");
        File destination = new File("src/assignmentnote.txt");



        copier.copyFile(source);
        copier.pasteFile(destination);
    }
}
