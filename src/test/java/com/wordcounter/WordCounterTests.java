package com.wordcounter;

import com.wordcounter.config.AppArguments;
import com.wordcounter.config.AppConfig;
import com.wordcounter.counter.Count;
import com.wordcounter.counter.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.StringReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTests {
    
    @ParameterizedTest
    @MethodSource("testTextProvider")
    void testWordCount(final String text, Count expectedResult) {
        WordCounter wordCounter = AppConfig.configureWordCounter(AppArguments.from(new String[]{}));
        assertEquals(expectedResult, wordCounter.count(() -> new StringReader(text)));
    }
    
    static Stream<Arguments> testTextProvider() {
        return Stream.of(
            Arguments.of("Mary had a little lamb", new Count(4, 4)),
            Arguments.of("Ma*ry had a little lamb",new Count( 4,4 )),
            Arguments.of("Mary had a little lamb.", new Count(4,4 )),
            Arguments.of("Mary had, a little lamb?", new Count( 4,4 )),
            Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", new Count( 9,7 ))
        );
    }
}
