package com.wordcounter.predicate;

/**
 * A predicate that checks if a word consists of contiguous letters. Any non-letter character will cause the predicate to return false.
 */
public class ContiguousWordPredicate implements WordPredicate {
    @Override
    public boolean test(String token) {
        for (char ch : token.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return !token.isEmpty();
    }
}
