package com.wordcounter.predicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopWordPredicateTest {


    public static Stream<Arguments> testWords() {
        return Stream.of( //
            Arguments.of(Set.of("a"), "word", true), //
            Arguments.of(Set.of("a"), "a", false), //
            Arguments.of(Set.of(), "a", true), //
            Arguments.of(null, "a", true) //
        );
    }

    @ParameterizedTest
    @MethodSource("testWords")
    void testStopWordPredicate(Set<String> givenStopWords, String givenText, boolean expected) {
        assertEquals(expected, new StopWordPredicate(givenStopWords).test(givenText));
    }
}
