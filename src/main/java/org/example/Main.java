package org.example;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WordsFile wordsFile = addingNewWords();
        flashcardsTest(wordsFile);

    }

    public static WordsFile addingNewWords(){
        Scanner scanner = new Scanner(System.in);
        WordsFile wordsFile = new WordsFile();
        String wantToAddMoreWords = "y";

        do {
            System.out.println("Enter the Polish word: ");
            String polishWord = scanner.next();

            System.out.println("Enter the English word: ");
            String englishWord = scanner.next();

            wordsFile.add(new PairOfWords(polishWord, englishWord));
            System.out.println("Would you like to add a word? (y/n)");
            wantToAddMoreWords = scanner.next();

        } while ("y".equals(wantToAddMoreWords));

        System.out.println("Finished");

        return wordsFile;
    }
    public static void flashcardsTest(WordsFile wordsFile){
        Scanner scanner = new Scanner(System.in);
        int counterOfPoints = 0;
        List<PairOfWords> listOfWords = wordsFile.readWords();
        for (PairOfWords word : listOfWords) {
            System.out.println("Enter the word \"" + word.polishWord() + "\" in English: ");
            String answer = scanner.next();
            if (answer.equals(word.englishWord())) {
                System.out.println("Congratulations, correct answer");
                counterOfPoints++;
            } else {
                System.out.println("Incorrect answer, the correct one is \"" + word.englishWord() +"\"");
            }
        }
        System.out.println("Final score: " + counterOfPoints);
    }
}