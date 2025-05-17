package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame{
    protected Store store;
    protected static JFrame startScreen;
    AddMediaButton button;
    public AddItemToStoreScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Add Media to Store");
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
                new AddDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Book Item");
            }
        });
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add CD Item");
            }
        });
        return menuBar;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6,2,2,2));

        UpdateValues cell1 = new UpdateValues("Enter title");
        center.add(cell1);
        UpdateValues cell2 = new UpdateValues("Enter category");
        center.add(cell2);
        UpdateValues cell3 = new UpdateValues("Enter cost");
        center.add(cell3);
        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
        startScreen = new AddItemToStoreScreen(store);
    }

}
