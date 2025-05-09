package hust.soict.itep.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    // Class member : have common variable to all objects(dvds)


    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc( String title, String category, double cost ) {
        super(title,category,cost);
    }

    public DigitalVideoDisc(String title, String category, String director, double cost) {
        super(title,category,director,cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        super(title,category,director,length,cost);
    }

    public String toString(){
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
            sb.append(" : [   ]$");
        }else{
            sb.append(" : [").append(String.format("%.2f", getCost())).append("]").append("$");
        }
        return sb.toString();
    }
    public boolean isMatch(String keyword){
        //finds out if the corresponding disk is a match given the title ??
        return getTitle().contains(keyword);
    }

    public boolean isInRange(double min, double max){
        return getCost() <= max && this.getCost() >= min;
    }
    public boolean isInRange(double max){
        return this.getCost() <= max;
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
