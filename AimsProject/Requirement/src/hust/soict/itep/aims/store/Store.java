package hust.soict.itep.aims.store;
import hust.soict.itep.aims.media.*;
import java.util.ArrayList;

public class Store {
    ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media){
        itemsInStore.add(media);
        System.out.println("Added " + media.getTitle() + " to the store");
    }
    public void removeMedia(Media media){
        itemsInStore.remove(media);
        System.out.println("Removed " + media.getTitle() + " from the store");
    }
}
