package com.wordcounter.counter;

import com.wordcounter.input.TextSource;
import com.wordcounter.tokenizer.TextTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class WordCounterImpl implements WordCounter {
    
    private final TextTokenizer textTokenizer;
    private final Predicate<String> wordPredicate;
    
    public WordCounterImpl(TextTokenizer textTokenizer, Predicate<String> wordPredicate) {
        this.textTokenizer = textTokenizer;
        this.wordPredicate = wordPredicate;
    }

    @Override
    public Count count(TextSource textSource) {
        List<String> result;
        try (BufferedReader reader = new BufferedReader(textSource.read())) {
            result = reader.lines()
                .flatMap(textTokenizer::tokenize)
                .filter(wordPredicate::test)
                .toList();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read text", e);
        }
        return new Count(result.size(), new HashSet<>(result).size());
    }
}
