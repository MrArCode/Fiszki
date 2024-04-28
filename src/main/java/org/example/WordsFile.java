package org.example;

import lombok.SneakyThrows;

import java.io.*;
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
                fileWriter.append(pairOfWords.getPolishWord() + "\n");
            } else {
                fileWriter.append(pairOfWords.getEnglishWord() + "\n");
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
    public List<String> readFromFile(File path) {
        List<String> list = new ArrayList<>();

        if (!path.exists()) {
            return list;
        }

        FileReader fileReader = new FileReader(path);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }


}
