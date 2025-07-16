package com.wordcounter.output;

import java.util.function.Supplier;

/**
 * The result writes outputs a given supplied value to a specified output stream.
 */
public interface ResultWriter<T> {
    
    void writeResult(T result);
}
