package nivell1Exercici2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Exercici2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> list2 = new ArrayList<>();

        ListIterator<Integer> it = list1.listIterator(list1.size());
        while (it.hasPrevious()) {
            list2.add(it.previous());
        }

        System.out.println("Original list: " + list1);
        System.out.println("Reversed list: " + list2);
    }
}
