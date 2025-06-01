package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> items = FXCollections.observableArrayList();

    public void addMedia(Media media) throws AimsException {
        if (items.size() >= MAX_NUMBERS_ORDERED) {
            throw new AimsException("Cart is full. Cannot add more items.");
        }
        items.add(media);
    }

    public void removeMedia(Media media) throws AimsException {
        if (!items.contains(media)) {
            throw new AimsException("Media not found in the cart.");
        }
        items.remove(media);
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                total += items.get(i).getCost();
            }
        }
        return total;
    }
    public void displayCart() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null) {
                System.out.println(i+1+".  "+ items.get(i).getTitle()+" "+ items.get(i).getCost());
            }
        }
    }
    public void sortByTitle() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i) != null && items.get(j) != null) {
                    if (items.get(i).getTitle().compareTo(items.get(j).getTitle()) > 0) {
                       Media tmp = items.get(i);
                        items.set(i, items.get(j));
                        items.set(j, tmp);
                    }
                }
            }
        }
    }
    public void sortByCost() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i) != null && items.get(j) != null) {
                    if (items.get(i).getCost() > items.get(j).getCost()) {
                        Media tmp = items.get(i);
                        items.set(i, items.get(j));
                        items.set(j, tmp);
                    }
                }
            }
        }
    }
    public void print() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
       System.out.println("***********************CART***********************");
       System.out.println("Ordered Items:");
         for (int i = 0; i < items.size(); i++) {
              if (items.get(i) != null) {
                System.out.println(i+1+".  "+ items.get(i).toString());
              }

         }
         System.out.println("Total cost: " + totalCost());
         System.out.println("***************************************************");
    }
    public void searchById(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId() == id) {
                System.out.println("Found: " + items.get(i).toString());
                return;
            }
        }
        System.out.println("Not found");
    }
    public void searchByTitle(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + items.get(i).toString());
                return;
            }
        }
        System.out.println("Not found");
    }
    public void getSize() {
        System.out.println("Size of cart: " + items.size());
    }

    public Media[] getItemsOrdered() {
        Media[] itemsOrdered = new Media[items.size()];
        for (int i = 0; i < items.size(); i++) {
            itemsOrdered[i] = items.get(i);
        }
        return itemsOrdered;
    }
    public ObservableList<Media> getItems() {
        return items;
    }
    public void filterByID(int idToFilter) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId() == idToFilter) {
                System.out.println("Found: " + items.get(i).toString());
                return;
            }
        }
        System.out.println("Not found");
    }

    public void filterByTitle(String titleToFilter) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getTitle().equalsIgnoreCase(titleToFilter)) {
                System.out.println("Found: " + items.get(i).toString());
                return;
            }
        }
        System.out.println("Not found");
    }


    public Media searchMedia(String titleToPlayFromCart) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getTitle().equalsIgnoreCase(titleToPlayFromCart)) {
                return items.get(i);
            }
        }
        System.out.println("Not found");
        return null;
    }

    public void emptyCart() {
        items.clear();
        System.out.println("Cart is empty");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1) {
        if (items.size() < MAX_NUMBERS_ORDERED) {
            items.add(dvd1);
            System.out.println("Added: " + dvd1.getTitle());
        } else {
            System.out.println("Cart is full");
        }
    }
}
