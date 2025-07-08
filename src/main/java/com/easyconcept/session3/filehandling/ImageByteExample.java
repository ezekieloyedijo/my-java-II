package com.easyconcept.session3.filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageByteExample {
    public static void main(String[] args) {
        Path source = Path.of("blouse-4-back.webp");
        Path destination = Path.of("blouse-4-back-copy.webp");

        try{
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("✅ Image copied successfully using java.nio.file.Files.");
        } catch (IOException e){
            System.out.println("❌ Failed to copy the image: " + e.getMessage());
        }

    }
}
