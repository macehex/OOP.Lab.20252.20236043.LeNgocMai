package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws AimsException {

            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to cart.");

    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        ((Playable) media).play();
    }
    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new javafx.geometry.Insets(0, 0, 0, 60));
        }
    }
}
