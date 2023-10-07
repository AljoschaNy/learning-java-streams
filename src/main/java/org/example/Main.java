package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = List.of(3,34,12,35,2,4,6,5);
        System.out.println("Initial: " + numbers.toString());

        //Schritt 1: Filtert eine Liste von Zahlen und gebt nur die geraden Zahlen aus.
        List<Integer> evenNumbers = numbers.stream().filter(n -> n%2 == 0).toList();
        System.out.println("Even: " + evenNumbers.toString());

        //Schritt 2: Verwendet 'map' und verdoppelt jede Zahl in der Liste.
        List<Integer> doubledNumbers = numbers.stream().map(n -> n*2).toList();
        System.out.println("Double: " + doubledNumbers.toString());

        // Schritt 3: Sortiert die Liste in aufsteigender Reihenfolge.
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        System.out.println("Sorted: " + sortedNumbers.toString());

        // Schritt 4: Führt eine 'reduce'-Operation durch, um die Summe aller Zahlen in der Liste zu berechnen.
        int sumOfNumbers = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sumOfNumbers);

        // Schritt 5: Nutzt 'forEach' und gebt jede verarbeitete Zahl aus.
        System.out.println("\nForeach:");
        numbers.stream().forEach(System.out::println);

        // Schritt 6: Sammelt die verarbeiteten Zahlen in einer neuen Liste mit 'collect'.
        List<Integer> array2 = numbers.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .sorted()
                .toList();

        System.out.println("Array before: " + numbers.toString());
        System.out.println("Edited array: " + array2.toString());
        System.out.println("\n");

        ArrayList<String> students = new ArrayList<>();

        System.out.println("Bonus");
        try (Stream<String> lines = Files.lines(Paths.get("students.csv"))) {
            lines.skip(1)
                .filter(line -> !line.isEmpty())
                .forEach(line -> {
                    if(!students.contains(line)) {
                        students.add(line);
                    }
            });

            for(int i = 0; i < students.size(); i++) {
                System.out.println("Index " + i + ": " + students.get(i));
            }
        } catch (IOException e) {
            System.out.println("Can't find the file");
        }
    }
}