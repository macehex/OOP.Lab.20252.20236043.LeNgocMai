package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    public AddCompactDiscToStoreScreen(Store store){
        super(store);
        setTitle("Add CD to Store");
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
        UpdateValues cell4 = new UpdateValues("Enter cost");
        center.add(cell4);
        UpdateValues cell5 = new UpdateValues("Enter artist");
        center.add(cell5);
        button = new AddMediaButton("CD");

        center.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.isButtonClicked = true;
                addCD(cell1,cell2,cell3,cell4,cell5);

            }
        });

        return center;
    }
    private void addCD(UpdateValues cell1,UpdateValues cell2,UpdateValues cell3,UpdateValues cell4,UpdateValues cell5){
        if(button.isButtonClicked){
            try {
                double cost = Double.parseDouble(cell4.data);
                String artist = cell5.data;
                CompactDisc cd = new CompactDisc(cell1.data, cell2.data, cell3.data, cost,artist);

                AddTrackToCompactDisc trackPanel = new AddTrackToCompactDisc(store,cd);
                store.addMedia(cd);

                System.out.println("Button worked, init add track to cd procedure");
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

