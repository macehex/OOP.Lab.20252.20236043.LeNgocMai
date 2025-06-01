package hust.soict.itep.aims.test.store;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreTest {
    public static void main(String[] args) throws AimsException {
        List<Media> mediaList = new ArrayList<Media>();
        Store store = new Store();
        CompactDisc cd1 = new CompactDisc(1,"Raumanian", "CD1", 60, 10.0f, "Artist1");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2,"Raumanian", "DVD1", "Director1", (int) 10.0f, 120); ;
        Book book1 = new Book(3, "Book1", "Category1", 15.0f);
        mediaList.add(cd1);
        mediaList.add(dvd1);
        mediaList.add(book1);
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }



    }
}
