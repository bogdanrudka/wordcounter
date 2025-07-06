package com.wordcounter;

import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.WordCounterImpl;
import com.wordcounter.predicate.ContiguousWordPredicate;
import com.wordcounter.tokenizer.SpaceTextTokenizer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.StringReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTests {
    
    private final WordCounter wordCounter = new WordCounterImpl(new SpaceTextTokenizer(), new ContiguousWordPredicate());
    
    @ParameterizedTest
    @MethodSource("testTextProvider")
    void testWordCount(final String text, int expectedCount) {
       assertEquals(expectedCount, wordCounter.count(() -> new StringReader(text)).totalWords());
    }

    /*
     * Enter text: Mary had a little lamb
     * Number of words: 5
     *
     * Enter text: Ma*ry had a little lamb
     * Number of words: 4
     *
     * Enter text: Mary had a little lamb.
     * Number of words: 4
     *
     * Enter text: Mary had, a little lamb?
     * Number of words: 3
     */
    static Stream<Arguments> testTextProvider() {
        return Stream.of(
            Arguments.of("Mary had a little lamb", 5),
            Arguments.of("Ma*ry had a little lamb", 4),
            Arguments.of("Mary had a little lamb.", 4),
            Arguments.of("Mary had, a little lamb?", 3)
        );
    }
}
