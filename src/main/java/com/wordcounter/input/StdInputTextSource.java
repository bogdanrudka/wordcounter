package com.wordcounter.input;

import java.io.*;
import java.util.Scanner;

/**
 * A TextSource that reads text from standard input (stdin). Reads single lines of text until the end of input.
 */
public class StdInputTextSource implements TextSource {

    @Override
    public Reader read() {
        System.out.println("Please enter text:");
        return new StringReader(new Scanner(System.in).nextLine());
    }
}
