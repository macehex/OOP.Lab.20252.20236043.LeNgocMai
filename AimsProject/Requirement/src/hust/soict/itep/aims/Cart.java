package hust.soict.itep.aims;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
    public int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        //check current quantity to see if cart is not already full
        if (qtyOrdered >= 20) {
            //can't add anymore discs!
            System.out.println("Cart is already full!");
            return;
        } else if (disc == null) {
            System.out.println("Cannot add null disc");
            return;
        }
        qtyOrdered++;

        //add disc to the list 
        itemsOrdered.add(disc);
        System.out.println("Added " + disc.getTitle() + " to the cart");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        //add dvdLíst to cart while checking qty ordered
        if (dvdList.length + qtyOrdered >= 20) {
            System.out.println("Can't add dvdList to the cart because the cart is full!");
            return;
        }
        for (DigitalVideoDisc dvd : dvdList) {
            qtyOrdered++;
            //add disc to the list
            itemsOrdered.add(dvd);
            System.out.println("Added " + dvd.getTitle() + " to the cart");

        }

    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if (2 + qtyOrdered >= 20) {
            System.out.println("Can't add two dvd to the cart because the cart is full!");
            return;
        }
            qtyOrdered+=2;
            //add disc to the list
            itemsOrdered.add(dvd1);
            itemsOrdered.add(dvd2);

            System.out.println("Added " + dvd1.getTitle() + " and "+  dvd2.getTitle() +" to the cart");

    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        //Check if theres an item
        if (!itemsOrdered.contains(disc)) {
            System.out.println("Disc can't be found in cart!");
            return;
        }
        System.out.println("Removed " + disc.getTitle() + " from the cart");
        itemsOrdered.remove(disc);
        qtyOrdered--;
    }

    public float totalCost() {
        float sum = 0;
        for (DigitalVideoDisc item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    public void displayCart() {
        for (DigitalVideoDisc item : itemsOrdered) {
            System.out.println((itemsOrdered.indexOf(item) + 1 + "  " + item.getTitle() + "  " + item.getCost()));
        }
        System.out.println("   Total Cost  " + totalCost());

    }
}   
