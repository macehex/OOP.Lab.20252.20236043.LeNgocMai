package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    ArrayList<Media> itemsOrdered = new ArrayList<>();
    public int qtyOrdered = 0;


    public void addMedia(ArrayList<Media> mediaArrayList){
        //add dvdLíst to cart while checking qty ordered
        if (qtyOrdered >= 20) {
            System.out.println("Can't add dvdList to the cart because the cart is full!");
            return;
        }
        for (Media mediaItem: mediaArrayList) {
            qtyOrdered++;
            //add disc to the array list
            itemsOrdered.add(mediaItem);
            System.out.println("Added " + mediaItem.getTitle() + " to the cart");
        }
    }

    public void addMedia(Media media) {
        //check current quantity to see if cart is not already full
        if (qtyOrdered >= 20) {
            //can't add anymore items!
            System.out.println("Cart is already full!");
            return;
        } else if (media == null) {
            System.out.println("Cannot add null media");
            return;
        }
        qtyOrdered++;

        //add disc to the list
        itemsOrdered.add(media);
        System.out.println("Added " + media.getTitle() + " to the cart");
    }

    public void removeMedia(Media media) {
        //Check if theres an item
        if (!itemsOrdered.contains(media)) {
            System.out.println("Media can't be found in cart!");
            return;
        }
        System.out.println("Removed " + media.getTitle() + " from the cart");
        itemsOrdered.remove(media);
        qtyOrdered--;
    }

    public double totalCost() {
        double sum = 0;
        for (Media item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    public void displayCart() {
        for (Media item : itemsOrdered) {
            System.out.println((itemsOrdered.indexOf(item) + 1 + "  " + item.getTitle() + "  " + item.getCost()));
        }
        System.out.println("   Total Cost  " + totalCost());

    }
    public void printCartOrdered(ArrayList<Media> mediaList ){
        System.out.println("*************************************CART*************************************");
        System.out.println("Ordered Items");
    //        Insert block here
//        Collections.sort(dvdlist);
        mediaList.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
        int i = 1;
        for(Media item : mediaList){
            if (item instanceof DigitalVideoDisc dvd) {
                System.out.println( String.valueOf(i)+". "+ dvd.toString(dvd));
                i++;
            }
        }
        System.out.println("Total cost of Cart including dvds : "+ totalCost());
        System.out.println("******************************************************************************");
    }


    public void searchDVD(int id){
        boolean val = false;
        for (Media mediaItem : itemsOrdered) {
            if (mediaItem instanceof DigitalVideoDisc dvd) {
                val = dvd.isMatch(id);
                if (val) {
                    System.out.println("Found DVD with the id of " + id + " : " + dvd.toString());
                    break;
                }
            }
        }

        if (!val){
            System.out.println("No match is found for the dvd with the id of "+String.valueOf(id));
        }
    }

    public void searchDVD(String keyword){
        boolean val = false;
        for (Media mediaItem : itemsOrdered) {
            if (mediaItem instanceof DigitalVideoDisc dvd) {
                if(dvd.isMatch(keyword)){
                    System.out.println("Found dvd with the keyword "+keyword+" :"+dvd.toString(dvd));
                    val = true;
                }
            }
        }

        if (!val){
            System.out.println("No match is found for the dvd with the keyword "+keyword);
        }
    }
    public void searchDVDCategory(String Category){
        boolean val = false;
        for(Media mediaItem : itemsOrdered){
            if(mediaItem instanceof DigitalVideoDisc dvd) {
                if(dvd.isMatchC(Category)){
                    System.out.println("Found dvd with the category of "+Category+" :"+dvd.toString(dvd));
                    val = true;
                }
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the category of "+Category);
        }
    }
    public void searchDVDPrice(double min, double max){
        boolean val = false;
        for(Media mediaItem : itemsOrdered) {
            if(mediaItem instanceof DigitalVideoDisc dvd){
                if(dvd.isInRange(min, max)){
                    System.out.println("Found dvd  with the price in range "+String.format("%.2f", min)+" - "+ String.format("%.2f", max)+" :"+dvd.toString(dvd));
                    val = true;
                }
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the price in range "+String.format("%.2f", min)+" - "+ String.format("%.2f", max));
        }

    }
    public void searchDVDPrice(double max){
        boolean val = false;
        for(Media mediaItem : itemsOrdered) {
            if(mediaItem instanceof DigitalVideoDisc dvd){
                if(dvd.isInRange(max)){
                    System.out.println("Found dvd  with the maximum price of " + String.format("%.2f", max)+" :"+dvd.toString(dvd));
                    val = true;
                }
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the maximum price of " + String.format("%.2f", max));
        }

    }
}   
