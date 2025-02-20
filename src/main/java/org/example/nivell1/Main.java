package org.example.nivell1;

import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Month> months = new ArrayList<>(Arrays.asList(
                new Month("January"), new Month("February"), new Month("March"),
                new Month("April"), new Month("May"), new Month("June"),
                new Month("July"), new Month("September"), new Month("October"),
                new Month("November"), new Month("December")
        ));

        months.add(7, new Month("August"));

        System.out.println("Months in order:");
        for (Month m : months) {
            System.out.println(m);
        }

        Set<Month> monthSet = new HashSet<>(months);
        System.out.println("\nMonths in HashSet (no duplicates):");
        for (Month m : monthSet) {
            System.out.println(m);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> reversedNumbers = new ArrayList<>();
        ListIterator<Integer> iterator = numbers.listIterator(numbers.size());
        while (iterator.hasPrevious()) {
            reversedNumbers.add(iterator.previous());
        }

        System.out.println("\nOriginal List: " + numbers);
        System.out.println("Reversed List: " + reversedNumbers);


        Map<String, String> countryCapitalMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("countries.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    countryCapitalMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        List<String> countries = new ArrayList<>(countryCapitalMap.keySet());
        Random random = new Random();
        int score = 0;

        for (int i = 0; i < 10; i++) {
            String country = countries.get(random.nextInt(countries.size()));
            System.out.print("What is the capital of " + country + "? ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase(countryCapitalMap.get(country))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + countryCapitalMap.get(country));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("classificacio.txt", true))) {
            writer.write(userName + " - " + score + " points\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Game over! Your score has been saved.");
    }
}