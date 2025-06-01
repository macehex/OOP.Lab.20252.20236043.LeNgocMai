package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel form;
    protected JButton addButton;
    protected StoreManagerScreen storeScreen;

    public AddItemToStoreScreen(Store store,StoreManagerScreen storeScreen, String title) {
        this.store = store;
        this.storeScreen=storeScreen;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createMenuBar(), BorderLayout.NORTH);

        form = new JPanel();
        createForm();

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        formPanel.add(form);
        cp.add(formPanel, BorderLayout.CENTER);

        if (addButton != null) {
            cp.add(addButton, BorderLayout.SOUTH);
        }

        setTitle(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    protected abstract void createForm();

    protected JTextField addInputField(String labelText) {
        form.add(new JLabel(labelText + ":"));
        JTextField field = new JTextField(20);
        form.add(field);
        return field;
    }
    protected void clearFields() {

    }
    protected void refreshStore() {
        if (storeScreen != null) {
            storeScreen.refreshStoreScreen();
        }
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> {
            dispose();  // Close the add item screen
        });
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            dispose();  // Close current screen
            new AddBookToStoreScreen(store, storeScreen);
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store, storeScreen);
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store, storeScreen);
        });
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

}
