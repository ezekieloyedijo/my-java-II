package com.easyconcept.session3;

import com.easyconcept.session3.filehandling.BufferReadWrite;
import com.easyconcept.session3.filehandling.OldReadExample;
import com.easyconcept.session3.filehandling.OldWriteExample;

public class MainFile {
    public static void main(String[] args) {
        // Write to file old way
        OldWriteExample oldWriteExample = new OldWriteExample();

//        oldWriteExample.write();

        // Read from file old way
        OldReadExample.read();

        // Read from file better
        OldReadExample.readNew();

        //
        BufferReadWrite.read();
        BufferReadWrite.write();
    }
}
