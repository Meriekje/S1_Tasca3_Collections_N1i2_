package nivell1;

import java.io.*;
import java.util.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        List<Month> months = new ArrayList<>(Arrays.asList(
                new Month("January"),
                new Month("February"),
                new Month("March"),
                new Month("April"),
                new Month("May"),
                new Month("June"),
                new Month("July"),
                new Month("September"),
                new Month("October"),
                new Month("November"),
                new Month("December")
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

    }

}