package org.example.nivell2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Restaurant> restaurantSet = new HashSet<>();
        restaurantSet.add(new Restaurant("Restaurant1", 8));
        restaurantSet.add(new Restaurant("Restaurant1", 7));
        restaurantSet.add(new Restaurant("Restaurant2", 9));
        restaurantSet.add(new Restaurant("Restaurant1", 8));

        System.out.println("HashSet (Avoiding duplicates):");
        for (Restaurant r : restaurantSet) {
            System.out.println(r);
        }

        Set<Restaurant> sortedRestaurants = new TreeSet<>(new RestaurantComparator());
        sortedRestaurants.addAll(restaurantSet);

        System.out.println("\nTreeSet (Sorted by name and rating descending):");
        for (Restaurant r : sortedRestaurants) {
            System.out.println(r);
        }
    }
}