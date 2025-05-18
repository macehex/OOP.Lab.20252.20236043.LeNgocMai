package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    private Store store;
    private static JFrame startScreen;
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 9.99f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 13,5.3f);
        store.addMedia(dvd2);
        Book book1 = new Book("How to get rich","Self-Help",12.4f);
        store.addMedia(book1);
        CompactDisc cd1 = new CompactDisc("New York mix","Mix tapes", 3.23);
        cd1.addTrack("Summer vibes", 1);
        cd1.addTrack("Soho", 1);
        cd1.addTrack("Midnight blue", 2);
        store.addMedia(cd1);
        CompactDisc cd2 = new CompactDisc("Jazzy Night","Single Album", 3.23);
        store.addMedia(cd2);

        startScreen = new StoreManagerScreen(store);

    }



    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel  createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }


    public JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        menu.add(viewStoreItem);


        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View store");
                startScreen = new StoreManagerScreen(store);
                dispose();
            }
        });
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add DVD Item");
                startScreen = new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Book Item");
                new AddBookToStoreScreen(store);
                dispose();

            }
        });
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add CD Item");
                new AddCompactDiscToStoreScreen(store);
                dispose();

            }
        });
        return menuBar;
    }
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i =0; i<9;i++){

            if(i>=mediaInStore.size()){
                continue;
            }else{
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            }
        }
        return center;
    }
}
