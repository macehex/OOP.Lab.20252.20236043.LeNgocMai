package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField directorField;
    private JTextField lengthField;
    private JTextField costField;

    public AddDigitalVideoDiscToStoreScreen(Store store,StoreManagerScreen storeScreen) {
        super(store, storeScreen, "Add DVD to Store");
    }

    @Override
    protected void createForm() {
        form.setLayout(new GridLayout(5, 2, 5, 5));

        titleField = addInputField("Title");
        categoryField = addInputField("Category");
        directorField = addInputField("Director");
        lengthField = addInputField("Length");
        costField = addInputField("Cost");

        addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String director = directorField.getText();
                int length = Integer.parseInt(lengthField.getText());
                float cost = Float.parseFloat(costField.getText());

                store.addMedia(new DigitalVideoDisc(
                        store.getItemsInStore().size() + 1,
                        title,
                        category,
                        director,
                        length,
                        cost
                ));
                JOptionPane.showMessageDialog(this, "DVD added successfully!");
                clearFields();
                refreshStore();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (AimsException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    @Override
    protected void clearFields() {
        titleField.setText("");
        categoryField.setText("");
        directorField.setText("");
        lengthField.setText("");
        costField.setText("");
    }
}