package hust.soict.itep.aims.store;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Store {
    ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added " + media.getTitle() + " to the store");
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
        System.out.println("Removed " + media.getTitle() + " from the store");
    }

    public void printStoreOrdered() {
        //yanked from printCartOrdered
        System.out.println("*************************************STORE*************************************");
        Collections.sort(itemsInStore, Media.COMPARE_BY_TITLE_COST);

        for (Media item : itemsInStore) {
            System.out.println(item);
        }
        System.out.println("******************************************************************************");
    }

    public Media returnMediaFromTitle(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        System.out.println("Invalid media Title!");
        return null;
    }
    public boolean isMediaInStore(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void playMediaFromTitle(String title) {
        if (isMediaInStore(title)) {
            Media media = returnMediaFromTitle(title);
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            } else {
                System.out.println("Unplayable media!");
            }
        } else {
            System.out.println("Can't find media with the title of: " + title);
        }
    }

    public static void addMediaToStore(Store store, Scanner input) {
        System.out.println("Enter media type (DVD/CD/Book): ");
        String mediaType = input.nextLine().trim();

        System.out.println("Enter title: ");
        String title = input.nextLine();

        System.out.println("Enter category: ");
        String category = input.nextLine();

        System.out.println("Enter cost: ");
        double cost = Double.parseDouble(input.nextLine());
        Media media;

        if (mediaType.equalsIgnoreCase("DVD")) {
              media = new DigitalVideoDisc(title, category, cost);
        } else if (mediaType.equalsIgnoreCase("CD")) {
            media = new CompactDisc(title, category, cost);
        }else if(mediaType.equalsIgnoreCase("Book")){
            media = new Book(title, category, cost);
        }
        else {
            System.out.println("Unknown media type.");
            return;
        }

        store.addMedia(media);
        System.out.println("Media added to store.");
    }
    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }

}