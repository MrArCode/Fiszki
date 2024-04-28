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
        File listOfPolishWords = new File(path, "polishWords");
        File listOfEnglishWords = new File(path, "englishWords");

        if (!file.exists()) {
            file.mkdir();
        }
        if (!listOfPolishWords.exists()) {
            listOfPolishWords.createNewFile();
        }
        if (!listOfEnglishWords.exists()) {
            listOfEnglishWords.createNewFile();
        }

        try (FileWriter fileWriter = new FileWriter(listOfPolishWords, true)) {
            fileWriter.append(pairOfWords.getPolishWord() + '\n');
            fileWriter.flush();
        }

        try (FileWriter fileWriter1 = new FileWriter(listOfEnglishWords, true)) {
            fileWriter1.append(pairOfWords.getEnglishWord() + '\n');
            fileWriter1.flush();
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

        if (!path.exists()){
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
