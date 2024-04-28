package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<PairOfWords> listOfWords = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to add a word? (y/n)");
        String wantToAddMoreWords = scanner.next();
        WordsFile wordsFile = new WordsFile();

        while ("y".equals(wantToAddMoreWords)) {
            System.out.println("Enter the Polish word: ");
            String polishWord = scanner.next();

            System.out.println("Enter the English word: ");
            String englishWord = scanner.next();

            wordsFile.add(new PairOfWords(polishWord, englishWord));

            System.out.println("Do you want to add another word? (y/n)");
            wantToAddMoreWords = scanner.next();
        }
        System.out.println("Finished");


        int counterOfPoints = 0;
        listOfWords = wordsFile.readWords();

        for (PairOfWords word : listOfWords) {
            System.out.println("Enter the word \"" + word.getPolishWord() + "\" in English: ");
            String answer = scanner.next();
            if (answer.equals(word.getEnglishWord())) {
                System.out.println("Congratulations, correct answer");
                counterOfPoints++;
            } else {
                System.out.println("Incorrect answer");
            }
        }

        System.out.println("Final score: " + counterOfPoints);

    }
}