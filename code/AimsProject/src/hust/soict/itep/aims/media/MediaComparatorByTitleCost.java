package hust.soict.itep.aims.media;

public class MediaComparatorByTitleCost implements java.util.Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        if (media1.getTitle().compareTo(media2.getTitle()) != 0) {
            return media1.getTitle().compareTo(media2.getTitle());
        } else {
            return Double.compare(media1.getCost(), media2.getCost());
        }
    }
}
