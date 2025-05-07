package hust.soict.itep.aims.media;

import java.util.Comparator;
public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());
        if (titleCompare == 0) {
            // If titles are equal, compare by cost (higher first)
            return Double.compare(m2.getCost(), m1.getCost());
        }
        return titleCompare;
    }
}
