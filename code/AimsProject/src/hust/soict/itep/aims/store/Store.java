package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists in the store.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Media added to the store: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("Media not found in the store.");
            return;
        }
        itemsInStore.remove(media);
        System.out.println("Media removed from the store: " + media);
    }

    public Media searchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
               // System.out.println("Media found: " + media.toString());
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
