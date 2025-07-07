package com.wordcounter.input;

import java.io.*;

public class FileInputTextSource implements TextSource {

    private final String filePath;

    public FileInputTextSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Reader read() {
        try {
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        }
    }
}
