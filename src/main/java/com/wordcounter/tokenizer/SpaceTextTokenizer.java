package com.wordcounter.tokenizer;

import java.util.stream.Stream;

/**
 * A tokenizer that splits text into words based on whitespace. Any number of whitespace characters (spaces, tabs, newlines) 
 * will be treated as a single delimiter.
 */
public class SpaceTextTokenizer implements TextTokenizer {
    
    @Override
    public Stream<String> tokenize(String text) {
        return text.isEmpty() ? Stream.empty() : Stream.of(text.split("\\s+"));
    }
}
