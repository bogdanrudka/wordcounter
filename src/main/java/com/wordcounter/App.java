package com.wordcounter;

import com.wordcounter.counter.WordCounter;
import com.wordcounter.counter.WordCounterImpl;
import com.wordcounter.input.StdInputTextSupplier;
import com.wordcounter.output.ResultWriter;
import com.wordcounter.output.PrintStreamResultWriter;
import com.wordcounter.predicate.ContiguousWordPredicate;
import com.wordcounter.tokenizer.SpaceTextTokenizer;

public class App {
    
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl(new SpaceTextTokenizer(), new ContiguousWordPredicate());
        ResultWriter resultWriter = new PrintStreamResultWriter(System.out, "Number of words: ");
        
        resultWriter.writeResult(wordCounter.count(new StdInputTextSupplier()));
    }
}
