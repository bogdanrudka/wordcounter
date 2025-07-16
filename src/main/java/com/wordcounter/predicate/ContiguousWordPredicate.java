package com.wordcounter.predicate;

import java.util.function.Predicate;

/**
 * A predicate that checks if a word consists of contiguous letters. Any non-letter character will cause the predicate to return false.
 */
public class ContiguousWordPredicate implements Predicate<String> {
    @Override
    public boolean test(String token) {
        if(token == null || token.isBlank()){
            return false;
        }
        for (char ch : token.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
}
