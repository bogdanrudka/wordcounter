package com.wordcounter.tokenizer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SymbolsTextTokenizerTest {

    @Test
    void testStringWithSpecialCharacters() {
        List<String> result = new SymbolsTextTokenizer().tokenize("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").toList();
        assertEquals(result, List.of("Humpty", "Dumpty", "sat", "on", "a",  "wall", "Humpty", "Dumpty", "had", "a", "great", "fall"));
    }
}
