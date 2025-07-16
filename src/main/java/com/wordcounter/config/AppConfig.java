package com.wordcounter.config;

import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.WordCounterImpl;
import com.wordcounter.input.*;
import com.wordcounter.predicate.StopWordPredicate;
import com.wordcounter.tokenizer.SymbolsTextTokenizer;

import java.util.function.Predicate;

public class AppConfig {

    public static WordCounter configureWordCounter(AppArguments appArguments) {
        Predicate<String> wordPredicate = configurePredicate(appArguments);
        return new WordCounterImpl(new SymbolsTextTokenizer(), wordPredicate);
    }

    public static TextSource configureTextSource(AppArguments appArguments) {
        TextSource textSource = new StdInputTextSource();
        if(appArguments.textFile() != null) {
            textSource = new FileInputTextSource(appArguments.textFile());
        }
        return textSource;
    }

    private static Predicate<String> configurePredicate(AppArguments appArguments) {
        return new StopWordPredicate(appArguments.stopWords());
    }
}
