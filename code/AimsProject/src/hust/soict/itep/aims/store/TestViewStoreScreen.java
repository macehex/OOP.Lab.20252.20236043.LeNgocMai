package hust.soict.itep.aims.store;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/itep/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store View");
        primaryStage.setScene(new javafx.scene.Scene(root));
        primaryStage.show();

    }
    public static void main(String[] args) throws AimsException {
        store = new Store();
        cart = new Cart();
        store.addMedia(new DigitalVideoDisc(1,"Harry Potter and the Philosopher's Stone", "Fantasy", "J.K. Rowling", 152, 3.0f));
        store.addMedia(new DigitalVideoDisc(2,"Harry Potter and the Chamber of Secrets", "Fantasy", "J.K. Rowling", 161, 3.5f));
        store.addMedia(new DigitalVideoDisc(3,"Harry Potter and the Prisoner of Azkaban", "Fantasy", "J.K. Rowling", 142, 5.0f));
        store.addMedia(new DigitalVideoDisc(4,"Harry Potter and the Goblet of Fire", "Fantasy", "J.K. Rowling", 157, 4.5f));
        store.addMedia(new DigitalVideoDisc(5,"Harry Potter and the Order of the Phoenix", "Fantasy", "J.K. Rowling", 138, 6.5f));
        store.addMedia(new DigitalVideoDisc(6,"Harry Potter and the Half-Blood Prince", "Fantasy", "J.K. Rowling", 153, 5.8f));
        store.addMedia(new DigitalVideoDisc(7,"Harry Potter and the Deathly Hallows - Part 1", "Fantasy", "J.K. Rowling", 146, 6.3f));
        store.addMedia(new DigitalVideoDisc(8,"Harry Potter and the Deathly Hallows - Part 2", "Fantasy", "J.K. Rowling", 130, 7.0f));
        store.addMedia(new DigitalVideoDisc(9,"Green Eggs and Ham", "Children's", "Dr. Seuss", 60, 3.3f));

        cart.addMedia(new DigitalVideoDisc(1,"Harry Potter and the Philosopher's Stone", "Fantasy", "J.K. Rowling", 152, 3.0f));
        cart.addMedia(new DigitalVideoDisc(2,"Harry Potter and the Chamber of Secrets", "Fantasy", "J.K. Rowling", 161, 3.5f));
        cart.addMedia(new DigitalVideoDisc(3,"Harry Potter and the Prisoner of Azkaban", "Fantasy", "J.K. Rowling", 142, 5.0f));
        launch(args);
    }
}
