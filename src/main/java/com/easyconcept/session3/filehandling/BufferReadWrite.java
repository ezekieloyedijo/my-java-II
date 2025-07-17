package com.easyconcept.session3.filehandling;

import java.io.*;

// best for large text or line by line reading
public class BufferReadWrite {
    // get the file
    // read it
    public static String read(){
        String classNote = "classnote.txt";
        StringBuilder content = new StringBuilder(); // To append text efficiently without creating new Object

       try (BufferedReader reader = new BufferedReader(new FileReader(classNote))) // Buffered reader so that reading is more Efficient
       {
            String line;
            // if end of file is reached, it returns null
            while((line = reader.readLine()) != null){
                content.append(line).append("\n"); // Add the line and newline
            }
           System.out.println("File read successfully.");
       }catch(IOException e){
           System.out.println("An error occurred while reading the file.");
           e.printStackTrace();
       }
        return content.toString();
    }

    // get the file
    // write into it
    public static void write(){
        String assignmentNote = "assignment.txt";
        String noteRead = BufferReadWrite.read();

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(assignmentNote))){
            bufferedWriter.write(noteRead);
            bufferedWriter.newLine(); // To preserve line breaks
            System.out.println("File pasted successfully.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
