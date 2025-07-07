package com.wordcounter;

import com.wordcounter.config.AppArguments;
import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.WordCounterImpl;
import com.wordcounter.input.*;
import com.wordcounter.output.PrintStreamResultWriter;
import com.wordcounter.output.ResultWriter;
import com.wordcounter.predicate.ContiguousWordPredicate;
import com.wordcounter.predicate.StopWordPredicate;
import com.wordcounter.tokenizer.SpaceTextTokenizer;

import java.util.function.Predicate;

public class App {
    
    public static void main(String[] args) {
        AppArguments appArguments = AppArguments.from(args);

        Predicate<String> wordPredicate = configurePredicate(appArguments);
        TextSource textSource = configureTextSource(appArguments);

        WordCounter wordCounter = new WordCounterImpl(new SpaceTextTokenizer(), wordPredicate);
        ResultWriter resultWriter = new PrintStreamResultWriter(System.out, "Number of words: ");
        
        resultWriter.writeResult(wordCounter.count(textSource));
    }

    private static TextSource configureTextSource(AppArguments appArguments) {
        TextSource textSource = new StdInputTextSource();
        if(appArguments.textFile() != null) {
            textSource = new FileInputTextSource(appArguments.textFile());
        }
        return textSource;
    }

    private static Predicate<String> configurePredicate(AppArguments appArguments) {
        Predicate<String> wordPredicate = new ContiguousWordPredicate();

        if (appArguments.stopWords() != null) {
            wordPredicate = wordPredicate.and(new StopWordPredicate(appArguments.stopWords()));
        }
        return wordPredicate;
    }
}
