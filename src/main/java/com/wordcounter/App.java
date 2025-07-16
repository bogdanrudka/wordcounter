package com.wordcounter;

import com.wordcounter.config.AppArguments;
import com.wordcounter.config.AppConfig;
import com.wordcounter.counter.WordCounter;
import com.wordcounter.input.*;
import com.wordcounter.output.PrintStreamResultWriter;
import com.wordcounter.output.ResultWriter;

public class App {
    
    public static void main(String[] args) {
        AppArguments appArguments = AppArguments.from(args);
        TextSource textSource = AppConfig.configureTextSource(appArguments);
        WordCounter wordCounter = AppConfig.configureWordCounter(appArguments);
        ResultWriter resultWriter = new PrintStreamResultWriter(System.out, "Number of words: ");
        
        resultWriter.writeResult(wordCounter.count(textSource));
    }
}
