package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    public AddBookToStoreScreen(Store store){
        super(store);
        setTitle("Add Book to Store");
    }
    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,2,2,2));

        UpdateValues cell1 = new UpdateValues("Enter Book's title");
        center.add(cell1);
        UpdateValues cell2 = new UpdateValues("Enter Book's category");
        center.add(cell2);
        UpdateValues cell3 = new UpdateValues("Enter Book's cost");
        center.add(cell3);

        button = new AddMediaButton("Book");

        center.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.isButtonClicked = true;
                addBook(cell1,cell2,cell3);

//                dispose();
            }
        });

        return center;
    }
    private void addBook(UpdateValues cell1,UpdateValues cell2,UpdateValues cell3){
        if(button.isButtonClicked){
            try {
                double cost = Double.parseDouble(cell3.data);
                Book book = new Book(cell1.data, cell2.data, cost);
                System.out.println("Button worked, added Book to store, init add author procedure");

                AddAuthorToBook authorPanel = new AddAuthorToBook(store,book);
                store.addMedia(book);


            } catch (NumberFormatException ex) {
                // If parsing fails, catch the exception
                System.err.println("Invalid number format for cost");
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
