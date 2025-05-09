package hust.soict.itep.aims.cart;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;

public class CartTest {
    public static void main(String[] args){
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        ArrayList<Media> dvdArrayList = new ArrayList<>();

        dvdArrayList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 28.15f));
        dvdArrayList.add(new DigitalVideoDisc("Star Wars", "Sci-Fi", null, 11.95f));
        dvdArrayList.add(new DigitalVideoDisc("Wars Of Thunder", "Documentary", null, 5.95f));  // No director

        dvdArrayList.add(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 88, 10.21f));

        cart.addMedia(dvdArrayList);
        cart.printCartOrdered();

        //Test search method here
        // Search by id
        cart.searchDVD(2);
        cart.searchDVD(10);
        // Search by title
//        When a customer searches for DVDs by title, he or she provides
//        a string of keywords.
//                If any DVD has the title containing any word in the string of keywords,
//                it is counted as a match.
//                Note that the comparison of words here is case-insensitive.
        cart.searchDVD("Star Wars");
        cart.searchDVD("Wars");
        cart.searchDVD("Eternal Sunshine of the spotless mind");
        cart.searchDVD("Eternal");
// search by category
//provides the category name.
// If any DVD has the matching category (case-insensitive)
        cart.searchDVDCategory("Animation");
        cart.searchDVDCategory("Sci-Fi");
        cart.searchDVDCategory("Thriller");
//When a customer searches for DVDs by price,
// he or she provides either the minimum and maximum cost,
// or just the maximum cost.
        cart.searchDVDPrice(5.1,11);
        cart.searchDVDPrice(7);
        cart.searchDVDPrice(1.0);

    }
}
