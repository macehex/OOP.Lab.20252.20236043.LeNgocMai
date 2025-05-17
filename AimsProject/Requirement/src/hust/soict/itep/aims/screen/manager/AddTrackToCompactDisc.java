package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrackToCompactDisc extends AddItemToStoreScreen{
    CompactDisc cd;
    public AddTrackToCompactDisc(Store store, CompactDisc cd) {
        super(store);
        this.cd = cd;
        setTitle("Add Track to CD");
    }

        @Override
        JPanel createCenter(){
            JPanel center = new JPanel();
            center.setLayout(new GridLayout(3,2,2,2));

            UpdateValues cell1 = new UpdateValues("Enter title");
            center.add(cell1);
            UpdateValues cell2 = new UpdateValues("Enter length");
            center.add(cell2);
            button = new AddMediaButton("Track");

            center.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.isButtonClicked = true;
                    addTracktoCD(cell1,cell2);

                }
            });

            return center;
        }
        private void addTracktoCD(UpdateValues cell1, UpdateValues cell2){
            if(button.isButtonClicked){
                try {
                    int length = Integer.parseInt(cell2.data);

                    cd.addTrack(new Track(cell1.data, length));

                    System.out.println("Button worked, add track to cd ");
                } catch (NumberFormatException ex) {
                    // If parsing fails, catch the exception
                    System.err.println("Invalid number format for length");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    System.err.println("Unknown Error");
                    ex.printStackTrace();
                }
            }else{
                System.out.println("Error");
            }
        }
    }
