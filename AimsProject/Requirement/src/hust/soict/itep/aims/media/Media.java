package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private static int nbMedias = 0;
    // instance attribute]
    private static int incrementId(){
        return nbMedias++;
    }
    protected int id;
    private String title;
    private String category;
    private double cost;

    public Media(String title, String category, double cost) {
        this.id = incrementId();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
        this.id = incrementId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Media media = (Media) o;
        return this.title.equals(media.title);
    }
    public boolean isMatch(int ID){
        //finds out if the corresponding disk is a match given the title ??
        return getId() == ID;
    }
    public boolean isMatch(String title){
        //finds out if the corresponding disk is a match given the title ??
        return getTitle().equals(title);
    }
    public boolean isMatchC(String Category){
        //finds out if the corresponding disk is a match given the category ??
        return getCategory().equals(Category);
    }



}
