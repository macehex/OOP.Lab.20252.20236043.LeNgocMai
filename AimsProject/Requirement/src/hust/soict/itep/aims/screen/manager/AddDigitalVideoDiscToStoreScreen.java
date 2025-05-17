package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }
    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6,2,2,2));

        UpdateValues cell1 = new UpdateValues("Enter title");
        center.add(cell1);
        UpdateValues cell2 = new UpdateValues("Enter category");
        center.add(cell2);
        UpdateValues cell3 = new UpdateValues("Enter director");
        center.add(cell3);
        UpdateValues cell4 = new UpdateValues("Enter length");
        center.add(cell4);
        UpdateValues cell5 = new UpdateValues("Enter cost");
        center.add(cell5);
        button = new AddMediaButton("DVD");

        center.add(button);

        addDVD(cell1,cell2,cell3,cell4,cell5);

        return center;
    }
    private void addDVD(UpdateValues cell1,UpdateValues cell2,UpdateValues cell3,UpdateValues cell4,UpdateValues cell5){
        if(button.isButtonClicked){
            try {
                int length = Integer.parseInt(cell4.data);
                double cost = Double.parseDouble(cell5.data);

                DigitalVideoDisc dvd = new DigitalVideoDisc(cell1.data, cell2.data, cell3.data, length, cost);
                store.addMedia(dvd);
                System.out.println("Button worked");
            } catch (NumberFormatException ex) {
                // If parsing fails, catch the exception
                System.err.println("Invalid number format for length or cost");
                ex.printStackTrace();
            } catch (Exception ex) {
                System.err.println("Unknown Error");
                ex.printStackTrace();
            }
        }else{
            //ReEnterValues
//            new AddDigitalVideoDiscToStoreScreen(store);
//            dispose();
            System.out.println("Error");
        }
    }
}

