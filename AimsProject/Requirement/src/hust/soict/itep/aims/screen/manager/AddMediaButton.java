package hust.soict.itep.aims.screen.manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMediaButton extends JButton {
    String mediaName;
    boolean isButtonClicked = false ;
    public AddMediaButton(String mediaName){
        this.mediaName = mediaName;
        this.setText("Add " + mediaName);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the button is clicked
                System.out.println("Add button clicked");
                isButtonClicked = true;
            }
        });
    }
}
