package com.wordcounter.tokenizer;

import java.util.stream.Stream;

/**
 * A tokenizer of of the text block.
 */
public interface TextTokenizer {
    /**
     * Tokenizes the given text into an iterator of words.
     *
     * @param text the text to tokenize
     * @return an iterator over the words in the text
     */
    Stream<String> tokenize(String text);
}
