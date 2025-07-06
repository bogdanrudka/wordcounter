package com.wordcounter.counter;

import com.wordcounter.input.TextSource;
import com.wordcounter.predicate.WordPredicate;
import com.wordcounter.tokenizer.TextTokenizer;

import java.io.BufferedReader;
import java.io.IOException;

public class WordCounterImpl implements WordCounter {
    
    private final TextTokenizer textTokenizer;
    private final WordPredicate wordPredicate;
    
    public WordCounterImpl(TextTokenizer textTokenizer, WordPredicate wordPredicate) {
        this.textTokenizer = textTokenizer;
        this.wordPredicate = wordPredicate;
    }

    @Override
    public Count count(TextSource textSource) {
        int totalWords;
        try (BufferedReader reader = new BufferedReader(textSource.read())) {
            totalWords = reader.lines()
                .flatMap(textTokenizer::tokenize)
                .filter(wordPredicate::test)
                .mapToInt(w -> 1)
                .sum();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read text", e);
        }
        return new Count(totalWords);
    }
}
