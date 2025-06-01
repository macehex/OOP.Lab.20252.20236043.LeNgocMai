package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;

    public AddBookToStoreScreen(Store store, StoreManagerScreen storeScreen) {
        super(store, storeScreen, "Add Book to Store");
    }

    @Override
    protected void createForm() {
        form.setLayout(new GridLayout(3, 2, 5, 5));

        titleField = addInputField("Title");
        categoryField = addInputField("Category");
        costField = addInputField("Cost");

        addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                store.addMedia(new Book(store.getItemsInStore().size() + 1, title, category, cost));
                JOptionPane.showMessageDialog(this, "Book added successfully!");

                clearFields();
                refreshStore();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (AimsException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    @Override
    protected void clearFields() {
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
    }
}