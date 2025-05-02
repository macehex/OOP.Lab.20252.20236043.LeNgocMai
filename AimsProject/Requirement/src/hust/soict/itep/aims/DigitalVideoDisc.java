package hust.soict.itep.aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    // Class member : have common variable to all objects(dvds)
    private static int nbDigitalVideoDiscs = 0;
    // instance attribute]
    private int id ;

    private int incrementId(){
        nbDigitalVideoDiscs ++;
        return id = nbDigitalVideoDiscs;
    }
    public int getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    DigitalVideoDisc(String title) {
        this.title = title;
        this.id = incrementId();
    }
    DigitalVideoDisc( String title, String category, float cost ) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = incrementId();

    }

    DigitalVideoDisc(String title, String category, String director,  float cost ) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.director = director;
        this.id = incrementId();

    }

    DigitalVideoDisc(String title, String category, String director, int length, float cost ) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.director = director;
        this.length = length;
        this.id = incrementId();

    }

    public void setTitle(String title) {
        this.title = title;
    }
}
