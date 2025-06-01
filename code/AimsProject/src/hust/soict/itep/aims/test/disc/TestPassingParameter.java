package hust.soict.itep.aims.test.disc;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        try {
            DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Tun", 60, 19.95f);
            DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "fgfd", 124, 24.95f);
            DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", "fgfd", 90, 18.99f);

            System.out.println("Before swapping: ");
            System.out.println("DVD1: " + dvd1.getTitle());
            System.out.println("DVD2: " + dvd2.getTitle());

            swap(dvd1, dvd2);

            System.out.println("After swapping: ");
            System.out.println("DVD1: " + dvd1.getTitle());
            System.out.println("DVD2: " + dvd2.getTitle());
        } catch (AimsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc temp = dvd1;
        dvd1 = dvd2;
        dvd2 = temp;
        System.out.println("Inside swap method: ");
        System.out.println("DVD1: " + dvd1.getTitle());
        System.out.println("DVD2: " + dvd2.getTitle());
    }
}