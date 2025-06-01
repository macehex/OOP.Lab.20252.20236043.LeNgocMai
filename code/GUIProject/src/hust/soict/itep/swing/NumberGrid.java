package hust.soict.itep.swing;

import javax.swing.*;
        import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(""+ i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        btnReset = new JButton("CLR");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);

    }

    public static void main(String[] args) {
        new NumberGrid();
    }
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String button = e.getActionCommand();
            if(button.charAt(0) >= '0' && button.charAt(0) <='9') {
                tfDisplay.setText(tfDisplay.getText()+button);
            }else if (button.equals("DEL")){
                //handles the "DEL" case

                String string = tfDisplay.getText();
                tfDisplay.setText(string.substring(0,string.length()-1));
                }
            else{
                //handles the "C" case
                tfDisplay.setText(null);
            }
        }
    }
}