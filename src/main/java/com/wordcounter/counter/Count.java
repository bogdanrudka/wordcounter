package com.wordcounter.counter;

import java.util.function.Supplier;

/**
 * A count of the total words in a text block.
 * @param totalWords the total number of words counted
 */
public record Count(int totalWords, int uniqueWords) implements Supplier<String> {
    @Override
    public String get() {
        return Integer.toString(totalWords);
    }
}
