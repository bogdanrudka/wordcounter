package com.wordcounter.output;

import java.io.PrintStream;
import java.util.function.Supplier;

/**
 * A ResultWriter that writes results to a PrintStream with a custom message.
 */
public class PrintStreamResultWriter implements ResultWriter {
    
    private final PrintStream out;
    private final String message;

    public PrintStreamResultWriter(PrintStream out, String message) {
        this.out = out;
        this.message = message;
    }

    @Override
    public void writeResult(Supplier<String> result) {
        out.println(message + result.get());
    }
}
