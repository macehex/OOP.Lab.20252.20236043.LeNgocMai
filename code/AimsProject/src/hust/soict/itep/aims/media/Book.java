package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.AimsException;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors= new ArrayList<>();

    public Book(int id,String title, String category, float cost) throws AimsException {
        super(id, title, category, cost);
    }
    public List<String> getAuthors() {
        return authors;
    }


    public void addAuthor(String author) {
        if (authors.contains(author)) {
            System.out.println("Author already exists.");
            return;
        }
        authors.add(author);
    }
    public void removeAuthor(String author) {
        if (!authors.contains(author)) {
            System.out.println("Author not found.");
            return;
        }
        authors.remove(author);
    }
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }

}
