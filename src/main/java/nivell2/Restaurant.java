package nivell2;

import java.util.*;

public class Restaurant {
    private String name;
    private int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Restaurant that = (Restaurant) obj;
        return rating == that.rating && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Rating: " + rating;
    }
}

class RestaurantComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant r1, Restaurant r2) {
        int nameComparison = r1.getName().compareTo(r2.getName());
        if (nameComparison == 0) {
            return Integer.compare(r2.getRating(), r1.getRating()); // Descending order for rating
        }
        return nameComparison;
    }
}


