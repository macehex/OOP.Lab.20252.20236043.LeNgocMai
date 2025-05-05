package hust.soict.itep.aims.media;

public class DigitalVideoDisc extends Disc{
    // Class member : have common variable to all objects(dvds)
    private static int nbDigitalVideoDiscs = 0;
    // instance attribute]
    private static int incrementId(){
        return nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        super(incrementId(),title);
    }
    public DigitalVideoDisc( String title, String category, double cost ) {
        super(incrementId(),title,category,cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(incrementId(),title,category,director,cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(incrementId(),title,category,director,length,cost);
    }

    public StringBuilder toString(DigitalVideoDisc dvd){
        StringBuilder sb = new StringBuilder();
        String BlankBox = " - [   ]";

//        1. DVD - [Title] - [category] - [Director] - [Length]: [Price] $
//        Consider dvd without all of the parameters too
//        IF parameter is uninitialized-> append a blank box ?? sb.append(BlankBox)
        sb.append("DVD");
        sb.append(" - [").append(getTitle()).append("]");
        if(getCategory() == null || getCategory().isEmpty()){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(getCategory()).append("]");
        }

        if(getDirector() == null || getDirector().isEmpty()){
           sb.append(BlankBox);
        }else{
            sb.append(" - [").append(getDirector()).append("]");
        }

        if(this.getLength()==0){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(this.getLength()).append("]");
        }

        if(getCost()==0.0f){
            sb.append(" : [   ]");
        }else{
            sb.append(" : [").append(String.format("%.2f", getCost())).append("]").append("$");
        }
        return sb;
    }
    public boolean isMatch(String keyword){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(getTitle().contains(keyword)){
            IsMatch = true;
        }
        return IsMatch;
    }
    public boolean isMatchC(String Category){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(getCategory().equals(Category)){
            IsMatch = true;
        }
        return IsMatch;
    }

    public boolean isMatch(int ID){
        //finds out if the corresponding disk is a match given the title ??
        boolean IsMatch = false;
        if(getId()==ID){
            IsMatch = true;
        }
        return IsMatch;
    }
    public boolean isInRange(double min, double max){
        boolean inRange = false;
        if(getCost()<=max&&this.getCost()>=min){
            inRange = true;
        }
        return inRange;
    }
    public boolean isInRange(double max){
        boolean inRange = false;
        if(this.getCost()<=max){
            inRange = true;
        }
        return inRange;
    }
}
