package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.*;

public class StoreTest {
    public static void main(String[] args) {
//        He or she must provide all information about the new DVD,
//        including its ID, title, category, director, length, and the cost.
//        Additionally, the manager can also remove DVDs from the store.
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",4, 28.15f);
        store.addMedia(dvd1);
        store.removeMedia(dvd1);
    }

}
