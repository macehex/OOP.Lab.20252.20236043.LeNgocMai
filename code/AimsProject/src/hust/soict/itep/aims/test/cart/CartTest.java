package hust.soict.itep.aims.test.cart;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Tun", 60, 19.95f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "fgfd", 124, 24.95f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", "fgfd", 90, 18.99f);

            cart.addDigitalVideoDisc(dvd1);
            cart.addDigitalVideoDisc(dvd2);
            cart.addDigitalVideoDisc(dvd3);

            cart.print();
        } catch (AimsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}