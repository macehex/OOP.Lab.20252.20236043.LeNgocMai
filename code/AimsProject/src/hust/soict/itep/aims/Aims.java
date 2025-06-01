package hust.soict.itep.aims;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.store.Store;
import javafx.scene.control.Alert;


import java.util.Scanner;

public class Aims {
    public static void main(String[] args) throws AimsException, PlayerException {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", "John Musker", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "The Little Mermaid", "Animation", "John Musker", 83, 19.99f);
        Track track1 = new Track("Track 1", 3);
        Track track2 = new Track("Track 2", 4);
        CompactDisc cd1 = new CompactDisc(5, "CD11", "Music", 60, 29.99f, "Artist 1");
        Book book1 = new Book(6, "Book 1", "Fiction", 15.99f);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(cd1);

        cart.addMedia(cd1);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book1);
        cart.addMedia(cd1);

        showMenu();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()) {
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 0:
                System.out.println("Goodbye!");
                break;
            case 1:

                storeMenu();
                int storeChoice = 0;
                if(scanner.hasNextInt()) {
                    storeChoice = scanner.nextInt();
                }
                switch (storeChoice) {
                    case 0:
                        System.out.println("Back to main menu");
                        showMenu();
                        break;
                    case 1:

                        System.out.println("Enter the title of the media: ");
                        String title = scanner.next();

                        if(store.searchMedia(title) == null) {
                            break;
                        }
                        mediaDetailsMenu();
                        int mediaChoice = 0;
                        if(scanner.hasNextInt()) {
                            mediaChoice = scanner.nextInt();
                        }
                        switch (mediaChoice) {
                            case 0:
                                System.out.println("Back to store menu");
                                storeMenu();
                                break;
                            case 1:
                                // Add to cart
                                cart.addMedia(store.searchMedia(title));
                                System.out.println(title + " added to cart");
                                break;
                            case 2: // Play from media details
                                Media media = store.searchMedia(title);
                                if (media == null) {
                                    System.out.println("Media not found");
                                } else {
                                    playMedia(media);
                                }
                                break;
                        }
                        break;
                    case 2:

                        System.out.println("Enter the title of the media: ");
                        String titleToAdd = scanner.next();
                        if(store.searchMedia(titleToAdd) == null) {
                            System.out.println("Media not found");
                            break;
                        }
                        cart.addMedia(store.searchMedia(titleToAdd));
                        System.out.println(titleToAdd + " added to cart");
                        cart.getSize();
                        break;
                    case 3:

                        System.out.println("Enter the title of the media: ");
                        String titleToPlay = scanner.next();
                        if(store.searchMedia(titleToPlay) == null) {
                            System.out.println("Media not found");
                            break;
                        }
                        Media mediaToPlay = store.searchMedia(titleToPlay);
                        if (mediaToPlay instanceof DigitalVideoDisc) {
                            ((DigitalVideoDisc) mediaToPlay).play();
                        } else if (mediaToPlay instanceof CompactDisc) {
                            ((CompactDisc) mediaToPlay).play();
                        } else {
                            System.out.println("Cannot play this media");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
                break;
            case 2:
                System.out.println("1. Add a media to store");
                System.out.println("2. Remove a media from store");
                int updateChoice = 0;
                if(scanner.hasNextInt()) {
                    updateChoice = scanner.nextInt();
                }
                switch (updateChoice) {
                    case 1:

                        System.out.println("Enter the type of media (1.Book, 2. DVD, 3. CD): ");
                        int mediaType = scanner.nextInt();
                        System.out.println("Enter the title of the media: ");
                        String title = scanner.next();
                        if (store.searchMedia(title) != null) {
                            System.out.println("Media already exists");
                            break;
                        }
                        System.out.println("Enter the ID of the media: ");
                        int id = -1;
                        boolean valid = false;
                        while (!valid) {
                            if (scanner.hasNextInt()) {
                                id = scanner.nextInt();
                                if (id> 0){
                                    valid = true;
                                    break;
                                } else {
                                    System.out.println("Invalid ID. Please enter a positive integer.");
                                }
                            }
                        }
                        System.out.println("Enter the category of the media: ");
                        String category = scanner.next();
                        System.out.println("Enter the cost of the media: ");
                        float cost = scanner.nextFloat();
                        // Input fields based on media type
                        String director = null;
                        int length = 0;
                        if (mediaType > 1) {
                            // Input director and length
                            System.out.println("Enter the director: ");
                            director = scanner.next();
                            System.out.println("Enter the length: ");
                            length = scanner.nextInt();
                        } else {
                            Book book = new Book(id, title, category, cost);
                            // Input author
                            System.out.println("Enter the author: ");
                            String author = scanner.next();
                            book.addAuthor(author);
                            // Add book to store
                            store.addMedia(book);
                            System.out.println(title + " added to store");
                            break;
                        }
                        if (mediaType == 2) {
                            // Create a new DVD
                            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, (int) cost, length);
                            // Add DVD to store
                            store.addMedia(dvd);
                            System.out.println(title + " added to store");
                        }
                        else if (mediaType == 3) {
                            // Input artist
                            System.out.println("Enter the artist: ");
                            String artist = scanner.next();
                            // Create a new CD
                            CompactDisc cd = new CompactDisc(id, title, category, (int) cost, length, artist);
                            // Add CD to store
                            store.addMedia(cd);
                            System.out.println(title + " added to store");
                        }
                        break;
                    case 2:
                        // Remove a media from store
                        System.out.println("Enter the title of the media: ");
                        String titleToRemove = scanner.next();
                        // Check the validity of the title
                        store.removeMedia(store.searchMedia(titleToRemove));
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            case 3:
                // See current cart
                cart.print();
                cartMenu();
                int cartChoice = 0;
                if(scanner.hasNextInt()) {
                    cartChoice = scanner.nextInt();
                }
                switch (cartChoice) {
                    case 0:
                        System.out.println("Back to main menu");
                        showMenu();
                        break;
                    case 1:
                        // Filter media in cart
                        System.out.println("Filter by (1. ID, 2. Title): ");
                        int filterChoice = scanner.nextInt();
                        switch (filterChoice) {
                            case 1:
                                System.out.println("Enter the ID: ");
                                int idToFilter = scanner.nextInt();
                                cart.filterByID(idToFilter);
                                break;
                            case 2:
                                System.out.println("Enter the title: ");
                                String titleToFilter = scanner.next();
                                cart.filterByTitle(titleToFilter);
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        break;
                    case 2:

                        System.out.println("Sort by (1. Title, 2. Cost): ");
                        int sortChoice = scanner.nextInt();
                        switch (sortChoice) {
                            case 1:
                                cart.sortByTitle();
                                cart.print();
                                break;
                            case 2:
                                cart.sortByCost();
                                cart.print();
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        break;
                    case 3:
                        // Play media from store
                        System.out.println("Enter the title of the media: ");
                        String titleToPlay = scanner.next();
                        Media mediaToPlay = store.searchMedia(titleToPlay);
                        if (mediaToPlay == null) {
                            System.out.println("Media not found");
                        } else {
                            playMedia(mediaToPlay);
                        }
                        break;
                    case 4:

                        System.out.println("Enter the title of the media: ");
                        String titleToPlayFromCart = scanner.next();
                        Media mediaToPlayFromCart = cart.searchMedia(titleToPlayFromCart);
                        if (mediaToPlayFromCart == null) {
                            System.out.println("Media not found in cart");
                        } else {
                            playMedia(mediaToPlayFromCart);
                        }
                        break;
                    case 5:

                        System.out.println("Order placed");
                        cart.emptyCart();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
        }
    }

    private static void playMedia(Media media) {
        try {
            if (media instanceof Playable) {
                System.out.println("Playing " + media.getTitle() + "...");
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable");
            }
        } catch (PlayerException e) {
            // Print detailed exception information
            System.err.println("Error Message: " + e.getMessage());
            System.err.println("Exception: " + e.toString());
            e.printStackTrace();

            // Show error dialog
            javafx.application.Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Cannot Play Media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            });
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-----------------------");
        System.out.println("0. Exit");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-----------------------");
        System.out.println("0. Back");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}