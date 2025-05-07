package hust.soict.itep.aims.media;

import hust.soict.itep.aims.cart.Cart;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {

        ArrayList<Media> medias = new ArrayList<>();
        CompactDisc cd = new CompactDisc("Hello World", "RoboMan");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",4, 28.15f);
        Book book = new Book("The Call of Cthulhu", "Horror", 6.3f);
        Book book2 = new Book("Hungry Dog", "Children", 6.3f);
        ArrayList<String> book2_authors = new ArrayList<>();
        book2_authors.add("Dr. John");
        book2_authors.add("Sir Hopkins");
        book2.setAuthors(book2_authors);

        medias.add(cd);
        medias.add(dvd);
        medias.add(book);
        medias.add(book2);
        for(Media m : medias){
            System.out.println(m.toString());
        }
        Cart cart = new Cart();
        cart.addMedia(medias);
        cart.printCartOrdered(medias);
    }

}
