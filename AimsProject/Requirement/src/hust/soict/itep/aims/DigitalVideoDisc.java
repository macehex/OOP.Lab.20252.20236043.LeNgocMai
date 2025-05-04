package hust.soict.itep.aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    // Class member : have common variable to all objects(dvds)
    private static int nbDigitalVideoDiscs = 0;
    // instance attribute]
    private int id ;

    private int incrementId(){
        nbDigitalVideoDiscs ++;
        return id = nbDigitalVideoDiscs;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getCategory() {
        return this.category;
    }
    public String getDirector() {
        return this.director;
    }
    public int getLength() {
        return this.length;
    }
    public double getCost() {
        return this.cost;
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

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.director = director;
        this.id = incrementId();

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
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
    public StringBuilder toString(DigitalVideoDisc dvd){
        StringBuilder sb = new StringBuilder();
        String BlankBox = " - [   ]";

//        1. DVD - [Title] - [category] - [Director] - [Length]: [Price] $
//        Consider dvd without all of the parameters too
//        IF parameter is uninitialized-> append a blank box ?? sb.append(BlankBox)
        sb.append("DVD");
        sb.append(" - [").append(this.title).append("]");
        if(this.category == null || this.category.isEmpty()){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(this.category).append("]");
        }

        if(this.director == null || this.director.isEmpty()){
           sb.append(BlankBox);
        }else{
            sb.append(" - [").append(this.director).append("]");
        }

        if(this.length==0){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(this.length).append("]");
        }

        if(this.cost==0.0f){
            sb.append(" : [   ]");
        }else{
            sb.append(" : [").append(String.format("%.2f", this.cost)).append("]").append("$");
        }
        return sb;
    }
    public boolean isMatch(String keyword){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(this.title.contains(keyword)){
            IsMatch = true;
        }
        return IsMatch;
    }
    public boolean isMatchC(String Category){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(this.category.equals(Category)){
            IsMatch = true;
        }
        return IsMatch;
    }

    public boolean isMatch(int ID){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(this.id==ID){
            IsMatch = true;
        }
        return IsMatch;
    }
    public boolean isInRange(double min, double max){
        boolean inRange = false;
        if(this.cost<=max&&this.cost>=min){
            inRange = true;
        }
        return inRange;
    }
    public boolean isInRange(double max){
        boolean inRange = false;
        if(this.cost<=max){
            inRange = true;
        }
        return inRange;
    }
}
