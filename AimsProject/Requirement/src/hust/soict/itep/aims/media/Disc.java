package hust.soict.itep.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    public Disc(int id, String title) {
        super(id,title);
    }
    public Disc( int id, String title, String category, double cost ) {
        super(id,title,category,cost);
    }
    public Disc(int id, String title, String category, String director, int length, double cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String director, int length) {
        super(id, title);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, String director, float cost) {
        super(id,title,category,cost);
        this.director=director;
    }
}