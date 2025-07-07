To run the application using maven execute the following command:

```bash
mvn exec:java -Dexec.args="-f ./stopwords.txt"
```

Where the `-f` argument specifies the path to the stopwords file. The application will read this file to filter out common words from the text it processes.
