package hust.soict.itep.aims;

import hust.soict.itep.aims.media.DigitalVideoDisc;

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
    public void addDigitalVideoDisc(ArrayList<DigitalVideoDisc> dvdArrayList){
        //add dvdLíst to cart while checking qty ordered
        if (qtyOrdered >= 20) {
            System.out.println("Can't add dvdList to the cart because the cart is full!");
            return;
        }
        for (DigitalVideoDisc dvd : dvdArrayList) {
            qtyOrdered++;
            //add disc to the array list
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
    public void printCartOrdered(ArrayList<DigitalVideoDisc> dvdlist ){
        System.out.println("*************************************CART*************************************");
        System.out.println("Ordered Items");
    //        Insert block here
//        Collections.sort(dvdlist);
        dvdlist.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
        int i = 1;
        for (DigitalVideoDisc item : dvdlist) {
            System.out.println( String.valueOf(i)+". "+ item.toString(item));
            i++;
        }
        System.out.println("Total cost: "+ totalCost());
        System.out.println("******************************************************************************");
    }
    public void searchDVD(int id){
        boolean val = false;
        for(DigitalVideoDisc dvd : itemsOrdered) {
            val = dvd.isMatch(id);
            if(val){
                System.out.println("Found dvd with the id of "+String.valueOf(id)+" :"+dvd.toString(dvd));
                break;
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the id of "+String.valueOf(id));
        }
    }

    public void searchDVD(String keyword){
        boolean val = false;
        for(DigitalVideoDisc dvd : itemsOrdered) {
            if(dvd.isMatch(keyword)){
                System.out.println("Found dvd with the keyword "+keyword+" :"+dvd.toString(dvd));
                val = true;
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the keyword "+keyword);
        }
    }
    public void searchDVDCategory(String Category){
        boolean val = false;
        for(DigitalVideoDisc dvd : itemsOrdered) {

            if(dvd.isMatchC(Category)){
                System.out.println("Found dvd with the category of "+Category+" :"+dvd.toString(dvd));
                val = true;
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the category of "+Category);
        }
    }
    public void searchDVDPrice(double min, double max){
        boolean val = false;
        for(DigitalVideoDisc dvd : itemsOrdered) {
            if(dvd.isInRange(min, max)){
                System.out.println("Found dvd  with the price in range "+String.format("%.2f", min)+" - "+ String.format("%.2f", max)+" :"+dvd.toString(dvd));
                val = true;
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the price in range "+String.format("%.2f", min)+" - "+ String.format("%.2f", max));
        }

    }
    public void searchDVDPrice(double max){
        boolean val = false;
        for(DigitalVideoDisc dvd : itemsOrdered) {
            if(dvd.isInRange(max)){
                System.out.println("Found dvd  with the maximum price of " + String.format("%.2f", max)+" :"+dvd.toString(dvd));
                val = true;
            }
        }
        if (!val){
            System.out.println("No match is found for the dvd with the maximum price of " + String.format("%.2f", max));
        }

    }
}   
