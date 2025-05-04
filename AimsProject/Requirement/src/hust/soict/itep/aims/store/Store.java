package hust.soict.itep.aims.store;

import hust.soict.itep.aims.DigitalVideoDisc;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store {
    ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore.add(dvd);
        System.out.println("Added " + dvd.getTitle() + " to the store");
    }
    public void removeDVD(DigitalVideoDisc dvd){
        itemsInStore.remove(dvd);
        System.out.println("Removed " + dvd.getTitle() + " from the store");
    }
}
