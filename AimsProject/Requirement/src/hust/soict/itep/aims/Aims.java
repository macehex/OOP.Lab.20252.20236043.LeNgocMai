package hust.soict.itep.aims;
public class Aims {
    public static void main(String[] args) {
        /*Create new cart*/
        Cart anOrder = new Cart();//Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //print total cost of cart
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.displayCart();
        // 13: remove items from the cart
        anOrder.removeDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Fight Club",
                "Action", 20.24f);
        anOrder.addDigitalVideoDisc(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Forest Gump",
                "Comedy", "Robert Zemeckis", 10.24f);
        anOrder.addDigitalVideoDisc(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 12.99f);
        anOrder.addDigitalVideoDisc(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski Sisters", 14.50f);
        anOrder.addDigitalVideoDisc(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 11.99f);
        anOrder.addDigitalVideoDisc(dvd8);

        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 15.75f);
        anOrder.addDigitalVideoDisc(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 13.45f);
        anOrder.addDigitalVideoDisc(dvd10);

        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 14.99f);
        anOrder.addDigitalVideoDisc(dvd11);

        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 16.99f);
        anOrder.addDigitalVideoDisc(dvd12);

        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Avengers: Endgame", "Superhero", "Anthony & Joe Russo", 17.50f);
        anOrder.addDigitalVideoDisc(dvd13);

        DigitalVideoDisc dvd14 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 12.25f);
        anOrder.addDigitalVideoDisc(dvd14);

        DigitalVideoDisc dvd15 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 11.80f);
        anOrder.addDigitalVideoDisc(dvd15);

        DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers & Rob Minkoff", 10.99f);
        anOrder.addDigitalVideoDisc(dvd16);

        DigitalVideoDisc dvd17 = new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 9.99f);
        anOrder.addDigitalVideoDisc(dvd17);

        DigitalVideoDisc dvd18 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 10.50f);
        anOrder.addDigitalVideoDisc(dvd18);

        DigitalVideoDisc dvd19 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck & Jennifer Lee", 12.75f);
        anOrder.addDigitalVideoDisc(dvd19);

        DigitalVideoDisc dvd20 = new DigitalVideoDisc("Coco", "Animation", "Lee Unkrich", 13.25f);
        anOrder.addDigitalVideoDisc(dvd20);
        DigitalVideoDisc dvd21 = new DigitalVideoDisc("House of Gucci", "Drama", 13.25f);
        anOrder.addDigitalVideoDisc(dvd21);

        DigitalVideoDisc dvd22 = new DigitalVideoDisc("500 days of Summer", "RomCom", 23.25f);
        anOrder.addDigitalVideoDisc(dvd22);

        anOrder.displayCart();

        //method overloading
        //
        Cart testCart = new Cart();
        DigitalVideoDisc[] dvdList = {
                new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 28.15f),
                new DigitalVideoDisc("Star Wars", "Sci-Fi", 11.95f),
                new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 88, 10.21f)
        };
        testCart.addDigitalVideoDisc(dvdList);
        testCart.displayCart();

        //14.2 Overloading by differing the number of parameters
        Cart testCart2 = new Cart();
        DigitalVideoDisc dvda = new DigitalVideoDisc("House of Gucci", "Drama", 13.25f);
        DigitalVideoDisc dvdb = new DigitalVideoDisc("500 days of Summer", "RomCom", 23.25f);

        testCart2.addDigitalVideoDisc(dvda, dvdb);
        testCart2.displayCart();

        System.out.println("The id of dvdb is: " + dvdb.getId());
    }
}