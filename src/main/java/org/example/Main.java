package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3,34,12,35,2,4,6,5);
        System.out.println("Initial: " + numbers.toString());

        //Schritt 1: Filtert eine Liste von Zahlen und gebt nur die geraden Zahlen aus.
        List<Integer> evenNumbers = numbers.stream().filter(n -> n%2 == 0).toList();
        System.out.println("Even: " + evenNumbers.toString());

        //Schritt 2: Verwendet 'map' und verdoppelt jede Zahl in der Liste.
        List<Integer> doubledNumbers = numbers.stream().map(n -> n*2).toList();
        System.out.println("Double: " + doubledNumbers.toString());

        // Schritt 3: Sortiert die Liste in aufsteigender Reihenfolge.
        List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted: " + sortedNumbers.toString());

        // Schritt 4: Führt eine 'reduce'-Operation durch, um die Summe aller Zahlen in der Liste zu berechnen.
        int sumOfNumbers = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sumOfNumbers);

        // Schritt 5: Nutzt 'forEach' und gebt jede verarbeitete Zahl aus.
        System.out.println("\nForeach:");
        numbers.stream().forEach(n -> System.out.println(n));

        // Schritt 6: Sammelt die verarbeiteten Zahlen in einer neuen Liste mit 'collect'.
        List<Integer> array2 = numbers.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Edited array: " + array2.toString());

    }
}