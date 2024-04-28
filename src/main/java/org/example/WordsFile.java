package org.example;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordsFile {
    //    private final String path = "/tmp/flashcards";
    private final String path = "src/main/java/org/example/listsOfWords";

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
        List<String> listOfPolishWords = new ArrayList<>();
        List<String> listOfEnglishWords = new ArrayList<>();

        FileReader fileOfPolishWords = new FileReader("src/main/java/org/example/listsOfWords/polishWords");
        FileReader fileOfEnglishWords = new FileReader("src/main/java/org/example/listsOfWords/englishWords");

        try (BufferedReader bufferedReaderPolish = new BufferedReader(fileOfPolishWords)) {
            String line;
            while ((line = bufferedReaderPolish.readLine()) != null) {
                listOfPolishWords.add(line);
            }
        } catch (IOException e) {
            System.out.println("There is no such file. You have to create the file first.");
            e.printStackTrace();
        }
        try (BufferedReader bufferedReaderEnglish = new BufferedReader(fileOfEnglishWords)) {
            String line;
            while ((line = bufferedReaderEnglish.readLine()) != null) {
                listOfEnglishWords.add(line);
            }
        } catch (IOException e) {
            System.out.println("There is no such file. You have to create the file first.");
            e.printStackTrace();
        }

        for (int i = 0; i < listOfPolishWords.size(); i++) {
            listOfWords.add(new PairOfWords(listOfPolishWords.get(i), listOfEnglishWords.get(i)));
        }
        return listOfWords;
    }


}
