package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends  JFrame {
    private Store store;
    private JPanel center;
    JPanel createNorth(){
        JPanel north= new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createHeader() {
        JPanel header=new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title= new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

   JMenuBar createMenuBar() {
        JMenu menu= new JMenu("Options");

       JMenuItem viewStore = new JMenuItem("View Store");

       menu.add(viewStore);
        JMenu smUpdateStore= new JMenu("Update Store");

       JMenuItem addBook = new JMenuItem("Add Book");
       addBook.addActionListener(e -> new AddBookToStoreScreen(store, this));

       JMenuItem addCD = new JMenuItem("Add CD");
       addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, this));

       JMenuItem addDVD = new JMenuItem("Add DVD");
       addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, this));

       smUpdateStore.add(addBook);
       smUpdateStore.add(addCD);
       smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar= new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();

            int itemsToDisplay = Math.min(mediaInStore.size(), 9);

            mediaInStore = store.getItemsInStore();
            for (int i = 0; i < itemsToDisplay; i++) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            }
            return center;

    }
    public void refreshStoreScreen() {
        Container cp = getContentPane();
        if (center != null) {
            cp.remove(center);
        }
        center = createCenter();
        cp.add(center, BorderLayout.CENTER);
        cp.revalidate();
        cp.repaint();
    }

    public StoreManagerScreen(Store store){
        this.store=store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);


        center = createCenter();
        cp.add(center, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        Store store = new Store();


        new StoreManagerScreen(store).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
