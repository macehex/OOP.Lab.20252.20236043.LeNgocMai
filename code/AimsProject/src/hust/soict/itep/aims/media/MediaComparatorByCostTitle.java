package hust.soict.itep.aims.media;

public class MediaComparatorByCostTitle implements java.util.Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getCost() > media2.getCost()) {
            return 1;
        } else if (media1.getCost() < media2.getCost()) {
            return -1;
        } else {
            return media1.getTitle().compareTo(media2.getTitle());
        }
    }
}
