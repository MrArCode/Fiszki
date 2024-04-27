package org.example;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] polskieSłowa = new String[3];
        String[] angielskieSłowa = new String[3];

        polskieSłowa[0] = "woda";
        polskieSłowa[1] = "ogień";
        polskieSłowa[2] = "ziemia";

        angielskieSłowa[0] = "water";
        angielskieSłowa[1] = "fire";
        angielskieSłowa[2] = "earth";

        int counter = 0;

        for (int i = 0; i < polskieSłowa.length; i++) {
            System.out.println("Podaj slowo " + polskieSłowa[i] + " w języku angielskim: ");
            String answer = scanner.next();
            if (answer.equals(angielskieSłowa[i])) {
                System.out.println("Gratulacje, poprawna odpowiedz");
                counter++;
            } else {
                System.out.println("Błe∂na odpowiedz");
            }

        }
        System.out.println("Ostateczny wynik:" + counter);
    }
}