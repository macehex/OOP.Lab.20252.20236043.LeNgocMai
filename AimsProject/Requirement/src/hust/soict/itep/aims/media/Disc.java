package hust.soict.itep.aims.media;

public class Disc extends Media {
    private String director;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    public Disc(String title) {
        super(title);
    }
    public Disc( String title, String category, double cost ) {
        super(title,category,cost);
    }
    public Disc(String title, String category, String director, int length, double cost) {
        super( title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String director, int length) {
        super( title);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, String director, double cost) {
        super(title,category,cost);
        this.director=director;
    }
}