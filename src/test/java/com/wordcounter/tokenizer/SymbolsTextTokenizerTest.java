package com.wordcounter.tokenizer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymbolsTextTokenizerTest {

    public static Stream<Arguments> testStrings() {
        return Stream.of( //
            Arguments.of("Humpty-Dumpty", List.of("Humpty", "Dumpty")), //  
            Arguments.of("wall. Great", List.of("wall", "Great")), // 
            Arguments.of("wall, great", List.of("wall", "great")), // 
            Arguments.of("wall! Great", List.of("wall", "Great")), // 
            Arguments.of("wall? Great", List.of("wall", "Great")), // 
            Arguments.of("wall!", List.of("wall")), // 
            Arguments.of("wall great", List.of("wall", "great")), // 
            Arguments.of("Ma*ry had", List.of("Ma*ry", "had")), // 
            Arguments.of("wall   great", List.of("wall", "great")), // 
            Arguments.of("", List.of()), // 
            Arguments.of(null, List.of()) // 
        );
    }

    @ParameterizedTest
    @MethodSource("testStrings")
    void testStringWithSpecialCharacters(String expectedText, List<String> expectedResult) {
        List<String> result = new SymbolsTextTokenizer().tokenize(expectedText).toList();
        assertEquals(result, expectedResult);
    }
}
