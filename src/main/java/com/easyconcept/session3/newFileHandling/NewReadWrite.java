package com.easyconcept.session3.newFileHandling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NewReadWrite {
    public static List<String> read() {
        Path path = Path.of("java1.txt");
        List<String> contents = new ArrayList<>();

        try{
            if(Files.exists(path)){
            contents = Files.readAllLines(path);
            for(String content : contents) {
                System.out.println(content);
            }

            }
        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        return contents;

    }

    public static void write(){
        Path path = Path.of("java2.txt");
        List<String> contents = read();
        try{
            Files.write(path, contents);
            // This appends the new content without overriding the previous content
            // Files.write(path, contents, StandardOpenOption.APPEND);

            // create file if the file does not exist
//            Files.write(path, contents, StandardOpenOption.CREATE, StandardOpenOption.APPEND)
            System.out.println("File written successfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
