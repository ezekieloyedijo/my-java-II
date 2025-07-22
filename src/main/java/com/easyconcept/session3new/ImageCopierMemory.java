package com.easyconcept.session3new;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImageCopierMemory {
    private List<byte[]> copiedImageChunks;

    public void copyImageToMemory(File sourceImage) {
        copiedImageChunks = new ArrayList<>();

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceImage))) {
            byte[] buffer = new byte[1024]; // 1KB chunks
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] chunk = new byte[bytesRead];
                System.arraycopy(buffer, 0, chunk, 0, bytesRead); // copy only the valid bytes
                copiedImageChunks.add(chunk);
            }

            System.out.println("Image copied into memory.");

        } catch (IOException e) {
            System.out.println("Error reading the image file");
            e.printStackTrace();
        }
    }

    public void pasteImageFromMemory(File destinationImage) {
        if (copiedImageChunks == null || copiedImageChunks.isEmpty()) {
            System.out.println("Nothing to paste. Copy an image first.");
            return;
        }

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destinationImage))) {
            for (byte[] chunk : copiedImageChunks) {
                outputStream.write(chunk);
            }

            System.out.println("Image written to: " + destinationImage.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error writing to the destination file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ImageCopierMemory copier = new ImageCopierMemory();

        File source = new File("blouse-4-back.webp");
        File destination = new File("src/copied-image.jpg");

        copier.copyImageToMemory(source);
        copier.pasteImageFromMemory(destination);
    }
}
