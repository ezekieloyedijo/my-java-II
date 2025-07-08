package com.easyconcept.session4.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyTask implements Runnable{
    private Path source;
    private Path destination;

    public FileCopyTask(Path source, Path destination){
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println("Starting file copy...");
        try{
            Thread.sleep(3000); // simulate 3-second delay
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("✅ File copy completed.");
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
