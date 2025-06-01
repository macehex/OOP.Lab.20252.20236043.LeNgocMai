package hust.soict.itep.aims.store;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class TestCartScreen extends Application {
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/itep/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(cart, new Store());
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Cart View");
        primaryStage.setScene(new javafx.scene.Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws AimsException {
        cart = new Cart();
        cart.addMedia(new DigitalVideoDisc(1, "Star Wars", "Sci-Fi", "Mai", 100, 128));
        cart.addMedia(new DigitalVideoDisc(2, "The Lion King", "Animation", "pmai", 120, 48));
        cart.addMedia(new DigitalVideoDisc(3, "Inception", "Sci-Fi", "Christopher Nolan", 150, 168));
        cart.addMedia(new DigitalVideoDisc(4, "The Matrix", "Sci-Fi", "Lana Wachowski", 130, 133));

        launch(args);
    }
}
