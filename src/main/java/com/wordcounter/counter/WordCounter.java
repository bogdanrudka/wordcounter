package com.wordcounter.counter;

import com.wordcounter.input.TextSource;

/**
 * The interface for counting words supplied by a TextSupplier.
 */
public interface WordCounter {
    /**
     * Counts the words provided by the given TextSupplier. Counts all words supplied by the TextSupplier, 
     * when reached the end of the stream, returns a Count object with the total count of words.
     *
     * @param textSupplier the supplier of text blocks
     * @return a Count object containing the count of words
     */
    Count count (TextSource textSupplier);
}
