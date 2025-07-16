package com.wordcounter.tokenizer;

import java.util.stream.Stream;

/**
 * Tokenizer that splits words with dash into multiple words.
 */
public class SymbolsTextTokenizer implements TextTokenizer{
    @Override
    public Stream<String> tokenize(String text) {
        return text == null || text.isEmpty() ? Stream.empty() : Stream.of(text.split("[\\s+.!?,\\-]+"));
    }
}
