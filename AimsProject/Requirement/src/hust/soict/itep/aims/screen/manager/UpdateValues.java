package hust.soict.itep.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateValues extends JPanel {
    private JTextField tfInput;
    String data;
    public UpdateValues(String inputPrompt){
        // Y_AXIS to stack things vertically
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setAlignmentY(CENTER_ALIGNMENT);

        JLabel prompt = new JLabel(inputPrompt);
        prompt.setFont(new Font(prompt.getFont().getName(),Font.PLAIN, 15));

        tfInput = new JTextField(40);

        // Add the label and text field to inputPanel
        inputPanel.add(prompt);
        inputPanel.add(tfInput);
        this.add(Box.createVerticalGlue());
        this.add(inputPanel);
        this.add(Box.createVerticalGlue());


        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        tfInput.addActionListener(new TFInputListener());

    }

    public String getInputText() {
        return tfInput.getText();
    }


    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            data = tfInput.getText();
            System.out.println("Input entered: " + data);
        }
    }
}
