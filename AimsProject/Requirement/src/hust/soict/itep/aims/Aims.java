package hust.soict.itep.aims;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.DigitalVideoDisc;

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
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

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

        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 9.99f);
        anOrder.addMedia(dvd17);

        DigitalVideoDisc dvd18 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 10.50f);
        anOrder.addMedia(dvd18);

        DigitalVideoDisc dvd19 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck & Jennifer Lee", 12.75f);
        anOrder.addMedia(dvd19);

        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 13.25f);
        anOrder.addMedia(dvd20);
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("House of Gucci", "Drama", 13.25f);
        anOrder.addMedia(dvd21);

        DigitalVideoDisc dvd22 = new DigitalVideoDisc("500 days of Summer", "RomCom", 23.25f);
        anOrder.addMedia(dvd22);

        anOrder.displayCart();



        System.out.println("The id of dvdb is: " + dvd1.getId());




//        System.out.println(dvd1.toString(dvd1));
    }

}