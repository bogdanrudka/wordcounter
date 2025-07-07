package com.wordcounter.predicate;

import java.util.Set;
import java.util.function.Predicate;

/**
 * A predicate that filters out stop words from a set of words.
 * It checks if a word is not present in the provided set of stop words.
 */
public class StopWordPredicate implements Predicate<String> {

    private final Set<String> stopWords;
    
    public StopWordPredicate(Set<String> stopWords) {
        this.stopWords = stopWords;
    }
    
    @Override
    public boolean test(String s) {
        return !stopWords.contains(s);
    }
}
