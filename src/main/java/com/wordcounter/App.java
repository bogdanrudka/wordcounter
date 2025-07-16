package com.wordcounter;

import com.wordcounter.config.AppArguments;
import com.wordcounter.config.AppConfig;
import com.wordcounter.counter.Count;
import com.wordcounter.counter.WordCounter;
import com.wordcounter.input.*;
import com.wordcounter.output.WordCountResultWriter;
import com.wordcounter.output.ResultWriter;

public class App {
    
    public static void main(String[] args) {
        AppArguments appArguments = AppArguments.from(args);
        TextSource textSource = AppConfig.configureTextSource(appArguments);
        WordCounter wordCounter = AppConfig.configureWordCounter(appArguments);
        ResultWriter<Count> resultWriter = new WordCountResultWriter(System.out);
        
        resultWriter.writeResult(wordCounter.count(textSource));
    }
}
