package com.wordcounter.output;

import com.wordcounter.counter.Count;

import java.io.PrintStream;

/**
 * A ResultWriter that writes results to a PrintStream with a custom message.
 */
public class WordCountResultWriter implements ResultWriter<Count> {
    
    public static final String MESSAGE = "Number of words: %s, unique: %s";
    private final PrintStream out;

    public WordCountResultWriter(PrintStream out) {
        this.out = out;
    }

    @Override
    public void writeResult(Count result) {
        out.println(MESSAGE.formatted(result.totalWords(), result.uniqueWords()));
    }
}
