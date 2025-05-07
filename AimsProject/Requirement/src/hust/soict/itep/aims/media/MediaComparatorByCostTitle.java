package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int costCompare = Double.compare(m2.getCost(), m1.getCost());
        if (costCompare == 0) {
            // If costs are equal, compare by title alphabetically
            return m1.getTitle().compareTo(m2.getTitle());
        }
        return costCompare;
    }

}
