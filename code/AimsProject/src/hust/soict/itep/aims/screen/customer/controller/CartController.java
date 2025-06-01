package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import hust.soict.itep.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Integer> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private HBox costLabel;
    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            ((Playable) selectedMedia).play();
        }
    }
    @FXML
    void btnRemovePressed(ActionEvent event) throws AimsException {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            tblMedia.refresh();
            updateTotalCost();
        }
    }

    private void updateTotalCost() {
        float totalCost = cart.totalCost();
        ((Label) costLabel.getChildren().get(1)).setText(totalCost + "$");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/itep/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.emptyCart();
        tblMedia.refresh();
        updateTotalCost();
        System.out.println("Order placed successfully!");
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Integer>("cost"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));

        tblMedia.setItems(cart.getItems());
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> updateButtonBar(newValue)
        );

        // Add filter listener
        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> showFilteredMedia());
    }
    void showFilteredMedia() {
        String filterText = tfFilter.getText().toLowerCase();
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItems(), item -> true);

        filteredList.setPredicate(item -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(item.getId()).contains(filterText);
            } else { // Filter by title
                return item.getTitle().toLowerCase().contains(filterText);
            }
        });

        tblMedia.setItems(filteredList);
    }
    private void updateButtonBar(Media media) {
        if(media==null) {
            btnPlay.setDisable(true);
            btnRemove.setDisable(true);
        } else {
           btnRemove.setVisible(true);
           if(media instanceof Playable) {
               btnPlay.setVisible(true);
           } else {
               btnPlay.setVisible(false);
           }
        }
    }


}
