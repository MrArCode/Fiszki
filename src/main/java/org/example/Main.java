package org.example;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Word> listOfWords = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to add a word? (y/n)");
        String wantToAddMoreWords = scanner.next();
        WordsFile wordsFile = new WordsFile();

        while ("y".equals(wantToAddMoreWords)){
            System.out.println("Enter the Polish word: ");
            String polishWord = scanner.next();

            System.out.println("Enter the English word: ");
            String englishWord = scanner.next();

            wordsFile.add(new Word(polishWord, englishWord));

            System.out.println("Do you want to add another word? (y/n)");
            wantToAddMoreWords = scanner.next();
        }
        System.out.println("Finished");







//        int counter = 0;
//
//        for (Word word: words) {
//            System.out.println("Podaj slowo " + word.getPolishWord() + " w języku angielskim: ");
//            String answer = scanner.next();
//            if (answer.equals(word.getEnglishWord())) {
//                System.out.println("Gratulacje, poprawna odpowiedz");
//                counter++;
//            } else {
//                System.out.println("Błe∂na odpowiedz");
//            }
//        }
//
//        System.out.println("Ostateczny wynik:" + counter);
    }
}