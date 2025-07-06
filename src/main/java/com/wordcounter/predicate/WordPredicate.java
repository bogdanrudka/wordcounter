package com.wordcounter.predicate;

/**
 * The predicate interface to check is a word meets criteria or word countability.
 */
public interface WordPredicate {
    /**
     * Tests if the given word meets the criteria defined by the predicate.
     
     * @param word the word to test
     * @return true if the word meets the criteria, false otherwise
     */
    boolean test(String word);
}
