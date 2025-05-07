package hust.soict.itep.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();
    private static int nbBooks = 0;
    // instance attribute]
    private static int incrementId(){
        return nbBooks++;
    }
    public Book(String title) {
        super(incrementId(), title);
    }
    public Book(String title, String category, float cost) {
        super(incrementId(), title, category, cost);
    }
    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(incrementId(), title, category, cost);
        this.authors = authors;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }


    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added " + authorName + " to the authors list");
        }
        System.out.println(authorName + " is already in the authors list!");

    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println(authorName + " is not in the authors list!");

        } else {
            authors.remove(authorName);
            System.out.println("Removed " + authorName + " from the authors list");
        }
    }
    public StringBuilder toString(Book book){
        StringBuilder sb = new StringBuilder();
        String BlankBox = " - [   ]";
        //        IF parameter is uninitialized-> append a blank box ?? sb.append(BlankBox)
        sb.append("Book");
        sb.append(" - [").append(this.getTitle()).append("]");
        if(this.getCategory() == null || this.getCategory().isEmpty()){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(this.getCategory()).append("]");
        }

//        if(this.getAuthors().isEmpty()){
//            sb.append(BlankBox);
//        }else{
//            sb.append(" - [").append(this.getAuthors()).append("]");
//        }
        if(this.getCost()==0.0f){
            sb.append(" : [   ]");
        }else{
            sb.append(" : [").append(String.format("%.2f", this.getCost())).append("]").append("$");
        }
        return sb;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String BlankBox = " - [   ]";

//        1. CD - [Title] - [category] - [author],[author],...: [Price]
//        IF parameter is uninitialized-> append a blank box ?? sb.append(BlankBox)
        sb.append("Book");
        sb.append(" - [").append(getTitle()).append("]");
        if(getCategory() == null || getCategory().isEmpty()){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(getCategory()).append("]");
        }
        if(getAuthors() == null || getAuthors().isEmpty()){
            sb.append(BlankBox);
        }else{
            for(String author_name : getAuthors()){
                sb.append(" - [").append(author_name).append("]");
            }
        }
        if(getCost()==0.0f){
            sb.append(" : [   ]");
        }else{
            sb.append(" : [").append(String.format("%.2f", getCost())).append("]").append("$");
        }

        return sb.toString();
    }

}

