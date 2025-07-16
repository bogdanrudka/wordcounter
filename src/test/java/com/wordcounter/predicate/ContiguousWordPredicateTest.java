package com.wordcounter.predicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContiguousWordPredicateTest {

    private final ContiguousWordPredicate predicate = new ContiguousWordPredicate();
    
    public static Stream<Arguments> testWords() {
        return Stream.of(
            Arguments.of("Word", true),
            Arguments.of("word", true),
            Arguments.of("Ma*ry", false),
            Arguments.of("word,", false),
            Arguments.of("", false),
            Arguments.of(null, false)
            
        );
    }

    @ParameterizedTest
    @MethodSource("testWords")
    void testContiguousWords(String givenWord, boolean expected) {
        assertEquals(expected, predicate.test(givenWord));
    }
}
