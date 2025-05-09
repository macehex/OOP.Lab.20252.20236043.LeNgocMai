package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    ArrayList<Media> itemsOrdered = new ArrayList<>();
    public int qtyOrdered = 0;
    public void emptyCart(){
        itemsOrdered = new ArrayList<>();
        qtyOrdered = 0;
        System.out.println("Cart is emptied!");
    }

    public void addMedia(ArrayList<Media> mediaArrayList){
        //add dvdLíst to cart while checking qty ordered
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
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
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
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
            System.out.println((itemsOrdered.indexOf(item) + 1 + "  " + item.getTitle() + "  " + String.format("%.2f",item.getCost())));
        }
        System.out.println("   Total Cost  " + String.format("%.2f", totalCost()));

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
    public void filterMedia(int id){
        boolean val = false;
        for (Media mediaItem : itemsOrdered) {
                val = mediaItem.isMatch(id);
                if (val) {
                    System.out.println("Found Media with the id of " + id + " : " + mediaItem.toString());
                    break;
                }
        }
        if (!val){
            System.out.println("No match is found for the media with the id of "+String.valueOf(id));
        }
    }
    public void filterMedia(String title){
        boolean val = false;
        for (Media mediaItem : itemsOrdered) {
            val = mediaItem.isMatch(title);
            if (val) {
                System.out.println("Found Media with the title of " + title + " : " + mediaItem.toString());
                break;
            }
        }
        if (!val){
            System.out.println("No match is found for the media with the titke of "+title);
        }
    }


    public void searchDVD(String keyword){
        boolean val = false;
        for (Media mediaItem : itemsOrdered) {
            if (mediaItem instanceof DigitalVideoDisc dvd) {
                if(dvd.isMatch(keyword)){
                    System.out.println("Found dvd with the keyword "+keyword+" :"+dvd.toString());
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
                    System.out.println("Found dvd with the category of "+Category+" :"+dvd.toString());
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
                    System.out.println("Found dvd  with the price in range "+String.format("%.2f", min)+" - "+ String.format("%.2f", max)+" :"+dvd.toString());
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
                    System.out.println("Found dvd  with the maximum price of " + String.format("%.2f", max)+" :"+dvd.toString());
                    val = true;
                }
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the maximum price of " + String.format("%.2f", max));
        }

    }
    public void fetchDVDCount(){
        int count = 0;
        for(Media item : itemsOrdered){
            if(item instanceof DigitalVideoDisc){
                count++;
            }
        }
        System.out.println("The number of DVDS in cart: "+count);
    }
    public void printCartOrdered() {
        System.out.println("*************************************CART*************************************");
        System.out.println("Ordered Items:");
//        mediaArrayList.sort(Media.COMPARE_BY_TITLE_COST);
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);

        for (Media item : itemsOrdered) {
            System.out.println(item);
        }
        System.out.printf("Total cost of Cart including dvds : %.2f\n", totalCost());
        System.out.println("******************************************************************************");
    }
    public void printCartOrderedbyCost() {
        System.out.println("*************************************CART*************************************");
        System.out.println("Ordered Items:");
//        mediaArrayList.sort(Media.COMPARE_BY_TITLE_COST);
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);

        for (Media item : itemsOrdered) {
            System.out.println(item);
        }
        System.out.printf("Total cost of Cart including dvds : %.2f\n", totalCost());
        System.out.println("******************************************************************************");
    }

    public void playMediaFromTitle(String title){
        if(isMediaInCart(title)){
            Media media = returnMediaFromTitle(title);
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            }else if(media instanceof CompactDisc){
                ((CompactDisc) media).play();
            }
            else{
                System.out.println("Unplayable media!");
            }
        }
        else {
            System.out.println("Can't find media with the title of: " + title);
        }
    }
    public boolean isMediaInCart(String title) {
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public Media returnMediaFromTitle(String title){
        for (Media item : itemsOrdered) {
            if (item.getTitle().equals(title)) {
                return item ;
            }
        }
        return null;
    }

}   
