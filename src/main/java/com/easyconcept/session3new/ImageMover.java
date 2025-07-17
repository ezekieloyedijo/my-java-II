package com.easyconcept.session3new;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

// This class copies so it does not read, that's why you didn't see the inputBufferedStream

public class ImageMover {
    private Path copiedImage; // stores location of the image

    // Method to copy the image from source and hold it in memory
    public void copyImage(Path source) {
        if (!Files.exists(source)) {
            System.out.println("Source image does not exist: " + source);
            return;
        }

        this.copiedImage = source;
        System.out.println("Image copied from: " + source.toAbsolutePath());
    }

    // Method to paste the image to a new destination
    public void pasteImage(Path destination) {
        if (copiedImage == null) {
            System.out.println("No image has been copied yet.");
            return;
        }

        try {
            Files.copy(copiedImage, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image pasted to: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to paste image.");
            e.printStackTrace();
        }
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        ImageMover mover = new ImageMover();

        Path sourcePath = Path.of("blouse-4-back.webp");
        Path destinationPath = Path.of("src/blouse-4-back.webp");

        mover.copyImage(sourcePath);
        mover.pasteImage(destinationPath);
    }
}
