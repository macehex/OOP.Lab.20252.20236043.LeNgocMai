package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.*;

import javax.swing.*;
import java.util.List;

public class PlayMediaJDialog {
    Media media;
    int track_num = 1;
    public PlayMediaJDialog(Media media) {
        this.media = media;
        if (media instanceof DigitalVideoDisc) {
            if (((DigitalVideoDisc) media).getLength() > 0) {
                String[] options = {"Return"};
                playDVD(options);
            } else {
                lengthError();
            }
        } else if (media instanceof CompactDisc) {
            String[] options = {"Return", "PLay Tracks"};
            playCD(options);
        }

    }

    public void playCD(String[] options) {
        int length = ((Disc) media).getLength();
        if (length <= 0) {
            lengthError();
        } else {
            String message = "CD: " + media.getTitle() + "\nlength: " + length;

            var choice = JOptionPane.showOptionDialog(null, message, "Options:",
                    0, 1, null, options, options[0]);
            for(
                 Track track : ((CompactDisc) media).tracks
            ){
                if (choice == 0) {
                        JOptionPane.showMessageDialog(null, "Return to View Store");
                        break;
                }else{
                        String cdOption = "Playing Track number: " + track_num++;
                        cdOption += "\n"+track.getTitle() +" with length of "+track.getLength();
                    JOptionPane.showConfirmDialog(null, cdOption, "Next Track", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public void playDVD(String[] options) {
        int length = ((Disc) media).getLength();

        String message = "PLaying DVD: " + media.getTitle() + "\nlength: " + length;
        var choice = JOptionPane.showOptionDialog(null, message, "Options:",
                0, 1, null, options, options[0]);
        JOptionPane.showMessageDialog(null,"Return to View Store");

    }

    public void lengthError() {
        JOptionPane.showMessageDialog(null, media.getClass().getSimpleName() + ": " + media.getTitle() + " has Invalid length");
    }


}
