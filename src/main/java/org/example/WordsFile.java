package org.example;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;

public class WordsFile {
    private final String path = "/tmp/fiszki";
    @SneakyThrows
    public void add (Word word){
        File file = new File(path);
        File polskie = new File(path, "polskie");
        File angielskie = new File(path, "angielskie");
        if (! file.exists()) {
            file.mkdir();
        }
        if (! polskie.exists()){
            polskie.createNewFile();
        }
        if (! angielskie.exists()){
            angielskie.createNewFile();
        }

        try(FileWriter fileWriter = new FileWriter(polskie))
        {
            fileWriter.append(word.getPolishWord());
            fileWriter.flush();
        }

        try(FileWriter fileWriter1 = new FileWriter(angielskie))
        {
            fileWriter1.append(word.getEnglishWord());
            fileWriter1.flush();
        }
    }

//    public List<Word> readWords()
    {

    }

}
