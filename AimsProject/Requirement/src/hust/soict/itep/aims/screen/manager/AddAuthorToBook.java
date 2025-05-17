package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAuthorToBook extends AddItemToStoreScreen {
    Book book ;
    public AddAuthorToBook(Store store, Book book){
        super(store);
        this.book = book;
        setTitle("Add Author to Book");
    }
    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,2,2,2));

        UpdateValues cell1 = new UpdateValues("Enter book's author");
        center.add(cell1);
        button = new AddMediaButton("Author");

        center.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.isButtonClicked = true;
                addAuthorToBook(cell1);
            }
        });

        return center;
    }
    private void addAuthorToBook(UpdateValues cell1){
        if(button.isButtonClicked){
            try {

                book.addAuthor(cell1.data);

                System.out.println("Button worked, add author to book");
            }catch(Exception ex){
                System.err.println("Unknown Error");
                ex.printStackTrace();
            }
        }else{
            System.out.println("Error");
        }
    }

}
