package nivell1Exercici3;

import java.io.*;
import java.util.*;

public class Exercici3{
    public static void main(String[] args) {
        Map<String, String> countryCapitalMap = new HashMap<>();
        String filename = "C:\\Users\\merit\\git\\S1_Tasca3_Collections_N1i2_\\src\\resources\\countries.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    countryCapitalMap.put(parts[0].trim(), parts[1].trim());
                }
            }

            if (countryCapitalMap.isEmpty()) {
                System.out.println("No country-capital data found in the file.");
                return;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        List<String> countries = new ArrayList<>(countryCapitalMap.keySet());
        Random random = new Random();
        int score = 0;
        Set<String> usedCountries = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            String randomCountry = countries.get(random.nextInt(countries.size()));
            while (usedCountries.contains(randomCountry)) {
                randomCountry = countries.get(random.nextInt(countries.size()));
            }

            usedCountries.add(randomCountry);
            System.out.print("What is the capital of " + randomCountry + "? ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase(countryCapitalMap.get(randomCountry))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + countryCapitalMap.get(randomCountry));
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("countries.txt", true))) {
            writer.write(userName + ": " + score + " points\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Your final score: " + score);
        scanner.close();
    }
}
