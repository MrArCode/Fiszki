package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordsFile {
    private final String path = "/tmp/flashcards";

    @SneakyThrows
    public void add(PairOfWords pairOfWords) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        createFolder(new File(path, "polishWords"), pairOfWords, "polish");
        createFolder(new File(path, "englishWords"), pairOfWords, "english");
    }

    @SneakyThrows
    public void createFolder(File file, PairOfWords pairOfWords, String whichFile) {
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (whichFile.equals("polish")) {
                fileWriter.append(pairOfWords.polishWord()).append(System.lineSeparator());
            } else {
                fileWriter.append(pairOfWords.englishWord()).append(System.lineSeparator());
            }
            fileWriter.flush();

        }
    }
    @SneakyThrows
    public List<PairOfWords> readWords() {
        List<PairOfWords> listOfWords = new LinkedList<>();
        List<String> listOfPolishWords = readFromFile(new File("/tmp/flashcards/polishWords"));
        List<String> listOfEnglishWords = readFromFile(new File("/tmp/flashcards/englishWords"));

        for (int i = 0; i < listOfPolishWords.size(); i++) {
            listOfWords.add(new PairOfWords(listOfPolishWords.get(i), listOfEnglishWords.get(i)));
        }
        return listOfWords;
    }

    @SneakyThrows
    public List<String> readFromFile(File file) {
        List<String> list = new ArrayList<>();

        if (!file.exists()) {
            return list;
        }

        list = Files.readAllLines(file.toPath());
        return list;
    }
}
