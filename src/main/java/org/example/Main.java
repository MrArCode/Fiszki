package org.example;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Words> words = new LinkedList<>();

//        polskieSłowa[0] = "woda";
//        polskieSłowa[1] = "ogień";
//        polskieSłowa[2] = "ziemia";
//
//        angielskieSłowa[0] = "water";
//        angielskieSłowa[1] = "fire";
//        angielskieSłowa[2] = "earth";

        System.out.println("Czy chesz dodac słowo y/n");
        String czyKontynuwać = scanner.next();

        while ("y".equals(czyKontynuwać)){
            System.out.println("Podaj polskie slowo: ");
            String polishWord = scanner.next();

            System.out.println("Podaj angielskie slowo: ");
            String englishWord = scanner.next();

            Words word = new Words(polishWord, englishWord);
            words.add(word);

            System.out.println("Czy chesz dodac słowo y/n");
            czyKontynuwać = scanner.next();
        }
        System.out.println("Skończone");





        int counter = 0;

        for (Words word: words) {
            System.out.println("Podaj slowo " + word.getPolishWord() + " w języku angielskim: ");
            String answer = scanner.next();
            if (answer.equals(word.getEnglishWord())) {
                System.out.println("Gratulacje, poprawna odpowiedz");
                counter++;
            } else {
                System.out.println("Błe∂na odpowiedz");
            }
        }

        System.out.println("Ostateczny wynik:" + counter);
    }
}