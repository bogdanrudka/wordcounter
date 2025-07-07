package com.wordcounter.config;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public record AppArguments(Set<String> stopWords, String textFile) {

    public static AppArguments from(String[] args) {
        String textFile = null;
        if (args.length > 0) {
            textFile = args[0];
        }
        return new AppArguments(loadStopWords("/stopwords.txt"), textFile);
    }

    public static Set<String> loadStopWords(String filePath) {
        Set<String> stopWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(AppArguments.class.getResourceAsStream(filePath)))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                if (!word.isEmpty()) {
                    stopWords.add(word);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read stop words file: " + filePath, e);
        }

        return stopWords;
    }
}
