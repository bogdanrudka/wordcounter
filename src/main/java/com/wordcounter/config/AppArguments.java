package com.wordcounter.config;

public record AppArguments(String stopWordsFile) {

   public static AppArguments from(String[] args) {
       String stopWordsFile = null;
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-f")) {
                if (i + 1 < args.length) {
                    stopWordsFile = args[++i];
                }
            }
        }
        return new AppArguments(stopWordsFile);
    }
}
