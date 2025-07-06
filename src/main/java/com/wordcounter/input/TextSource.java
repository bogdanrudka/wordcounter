package com.wordcounter.input;

import java.io.Reader;

/**
 * A supplier of text blocks. This interface is used to provide text input for processing.
 */
public interface TextSource {

    /**
     * Reads the next text block from the source.
     *
     * @return reader for reading the text block
     */
    Reader read();
}
