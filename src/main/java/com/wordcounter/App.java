package com.wordcounter;

import com.wordcounter.config.AppArguments;
import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.WordCounterImpl;
import com.wordcounter.input.StdInputTextSupplier;
import com.wordcounter.output.ResultWriter;
import com.wordcounter.output.PrintStreamResultWriter;
import com.wordcounter.predicate.ContiguousWordPredicate;
import com.wordcounter.predicate.StopWordPredicate;
import com.wordcounter.tokenizer.SpaceTextTokenizer;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class App {
    
    public static void main(String[] args) {
        AppArguments appArguments = AppArguments.from(args);

        Predicate<String> wordPredicate = new ContiguousWordPredicate();

        if (appArguments.stopWordsFile() != null) {
            wordPredicate = wordPredicate.and(new StopWordPredicate(loadStopWords(appArguments.stopWordsFile())));
        }
        
        WordCounter wordCounter = new WordCounterImpl(new SpaceTextTokenizer(), wordPredicate);
        ResultWriter resultWriter = new PrintStreamResultWriter(System.out, "Number of words: ");
        
        resultWriter.writeResult(wordCounter.count(new StdInputTextSupplier()));
    }
    
    public static Set<String> loadStopWords(String filePath) {
        Set<String> stopWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
