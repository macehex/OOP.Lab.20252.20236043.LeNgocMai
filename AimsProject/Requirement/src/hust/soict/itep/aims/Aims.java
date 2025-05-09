package hust.soict.itep.aims;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;
import java.util.Scanner;
public class Aims {
    public static void main(String[] args) {
        /*Create new cart*/
        Cart anOrder = new Cart();//Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addMedia(dvd3);

        //print total cost of cart
        System.out.printf("Total cost is: ");
        System.out.printf("%.2f\n", anOrder.totalCost());

        anOrder.displayCart();
        // 13: remove items from the cart
        anOrder.removeMedia(dvd2);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Fight Club",
                "Action", 20.24f);
        anOrder.addMedia(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Forest Gump",
                "Comedy", "Robert Zemeckis", 10.24f);
        anOrder.addMedia(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 12.99f);
        anOrder.addMedia(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski Sisters", 14.50f);
        anOrder.addMedia(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 11.99f);
        anOrder.addMedia(dvd8);

        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 15.75f);
        anOrder.addMedia(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 13.45f);
        anOrder.addMedia(dvd10);

        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 14.99f);
        anOrder.addMedia(dvd11);

        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 16.99f);
        anOrder.addMedia(dvd12);

        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Avengers: Endgame", "Superhero", "Anthony & Joe Russo", 17.50f);
        anOrder.addMedia(dvd13);

        DigitalVideoDisc dvd14 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 12.25f);
        anOrder.addMedia(dvd14);

        DigitalVideoDisc dvd15 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 11.80f);
        anOrder.addMedia(dvd15);

        DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers & Rob Minkoff", 10.99f);
        anOrder.addMedia(dvd16);
        anOrder.displayCart();
        System.out.println(dvd1.toString());


        System.out.println("The id of dvd3 is: " + dvd3.getId());

// start of final ex
        Store store = new Store();
        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 9.99f);
        store.addMedia(dvd17);
        DigitalVideoDisc dvd18 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 10.50f);
        store.addMedia(dvd18);
        DigitalVideoDisc dvd19 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck & Jennifer Lee", 12.75f);
        store.addMedia(dvd19);
        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 13.25f);
        store.addMedia(dvd20);
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("House of Gucci", "Drama", 13.25f);
        store.addMedia(dvd21);
        DigitalVideoDisc dvd22 = new DigitalVideoDisc("500 days of Summer", "RomCom", 23.25f);
        store.addMedia(dvd22);


        Cart userCart = new Cart();
        showMenu(store, userCart);

    }

    public static void showMenu(Store store, Cart userCart) {
        Scanner input = new Scanner(System.in);
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int user_keyboard = Integer.valueOf(input.nextLine());
        switch (user_keyboard) {
            case 1:
                store.printStoreOrdered();
                storeMenu(store, userCart);
                break;
            case 2:
                // add a media or remove media from store
                store.printStoreOrdered();
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Add a media to the store");
                System.out.println("2. Remove a media from the store");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4");
                int value = Integer.valueOf(input.nextLine());
                switch (value) {
                    case 1:
                        //add media to the store
                        Store.addMediaToStore(store, input);
                        showMenu(store,userCart);
                        break;
                    case 2:
                        //remove media from the store
                        System.out.println("Enter title to remove");
                        String title = input.nextLine();
                        store.removeMedia(store.returnMediaFromTitle(title));
                        showMenu(store,userCart);
                        break;
                }
                break;
            case 3:
                //see current cart
                userCart.printCartOrdered();
                cartMenu(store, userCart);
                break;
            default:
                System.out.println("Exiting AIMS");
                break;
        }


    }

    public static void storeMenu(Store store, Cart userCart) {
        Scanner input = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int user_keyboard = Integer.valueOf(input.nextLine());
        switch (user_keyboard) {
            case 1:
                //see a media's details
                System.out.println("Enter the title of the media to see details");
                String title = input.nextLine();
                if (store.isMediaInStore(title)) {
                    mediaDetailsMenu(store.returnMediaFromTitle(title),store,userCart);
                }
                break;
            case 2:
                System.out.println("Enter the title of the media to add to cart");
                String title2 = input.nextLine();
                // add media to cart
                userCart.addMedia(store.returnMediaFromTitle(title2));
                break;
            case 3:
                System.out.println("Enter the title of the media to play");
                String title3 = input.nextLine();
                // fetch media
                //play media
                store.playMediaFromTitle(title3);
                break;
            case 4:
                //see current cart
                userCart.printCartOrdered();
                cartMenu(store, userCart);
            default:
                System.out.println("Back");
                showMenu(store, userCart);
                break;

        }
    }

    public static void cartMenu(Store store, Cart userCart) {
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

        Scanner input = new Scanner(System.in);
        int user_keyboard = Integer.valueOf(input.nextLine());

        switch (user_keyboard) {
            case 1:
                //chose one of the filtering option
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Filter by ID");
                System.out.println("2. Filter by Title");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");

                int option = Integer.valueOf(input.nextLine());
                switch (option) {
                    case 1:
                        //filtering by id
                        System.out.println("Input ID");
                        int id = Integer.valueOf(input.nextLine());
                        userCart.filterMedia(id);
                        break;
                    case 2:
                        //filering by title
                        System.out.println("Input Title");

                        String title = input.nextLine();
                        userCart.filterMedia(title);
                        break;
                    default:
                        cartMenu(store, userCart);
                        break;
                }
                break;
            case 2:
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Sort by title");
                System.out.println("2. Sort by cost");
                System.out.println("0. Back");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2");
                userCart.printCartOrdered();
                userCart.printCartOrderedbyCost();
                int value = Integer.valueOf(input.nextLine());
                switch (value) {
                    case 1:
                        userCart.printCartOrdered();
                        cartMenu(store, userCart);

                        break;
                    case 2:
                        userCart.printCartOrderedbyCost();
                        cartMenu(store, userCart);

                        break;
                    default:
                        cartMenu(store, userCart);
                        break;
                }
            case 3:
                //remove a media from cart
                String title = input.nextLine();
                userCart.removeMedia(store.returnMediaFromTitle(title));
                cartMenu(store, userCart);
                break;
            case 4:
                System.out.println("Enter the title of the media to play");
                String mediaName = input.nextLine();
                // fetch media
                //play media
                userCart.playMediaFromTitle(mediaName);
                break;
            case 5:
                System.out.println("An order is created");
                //empty current cart:
                userCart.emptyCart();
                showMenu(store, userCart);
                break;
            default:
                showMenu(store, userCart);
                break;
        }
    }

    public static void mediaDetailsMenu(Media media, Store store, Cart userCart) {
        Scanner input = new Scanner(System.in);
        boolean playValid = false;
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
            System.out.println("2. Play");
            playValid = true;
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int value = Integer.valueOf(input.nextLine());
        switch (value) {
            case 1:
                userCart.addMedia(media);
                storeMenu(store,userCart);
            case 2:
                if (playValid) {
                    if (media instanceof CompactDisc) {
                        ((CompactDisc) media).play();
                    } else {
                        ((DigitalVideoDisc) media).play();
                    }
                } else {
                    System.out.println("Invalid option!");
                }
                storeMenu(store,userCart);
                break;
            default:
                input.close();
                storeMenu(store,userCart);
                break;
        }


    }

}