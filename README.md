To run the application using maven execute the following command:

```bash
mvn exec:java -Dexec.args="-f ./stopwords.txt"
```

Where the `-f` argument specifies the path to the stopwords file. The application will read this file to filter out common words from the text it processes.


Build
To build the project, you can use the following command:

```bash
mvn clean package
```
This will produce a wordcount.zip with runnable bin and library. 
You can then run the application using the provided scripts in the `bin` directory.
