package hust.soict.itep.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }


    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }
    public CompactDisc(String title,String  category,double cost){
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, double cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc( String title, String category, String director, int length, double cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
//    public CompactDisc(int id, String title, String director, int length, String artist) {
//        super(id, title, director, length);
//        this.artist = artist;
//    }

    public CompactDisc( String title, String category, String director, double cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }
    public void addTrack(String title, int length){
        //Check track title first!

        if(tracks.stream().anyMatch(t -> t.getTitle().equals(title))){
            System.out.println("Track title: "+ title+" already exist in tracks list!");
        }else {
            tracks.add(new Track(title,length));
            System.out.println("Ädded "+title+" to tracks");
        }
    }
    public void removeTrack(String title){
        if(tracks.stream().anyMatch(t -> t.getTitle().equals(title))){
            tracks.removeIf(track -> track.getTitle().equals(title));
            System.out.println("Removed "+ title+" from tracks list");

        }else {
            System.out.println(title+" isn't in the tracks list!");
        }
    }



    @Override
    public int getLength() {
        //Length = the combined length of all tracks
         int combinedLength = 0 ;
         for(Track a_track : tracks){
             combinedLength += a_track.getLength();
         }
         return combinedLength;
    }
    public void play() {
        System.out.println("Playing CompactDisc: " + this.getTitle());
        System.out.println("CompactDisc's length: " + this.getLength());
        //Loop through each track in the array list
        System.out.println("Playing available tracks");
        int track_num = 1;
        for(Track track : tracks){
            System.out.println("Track number: "+track_num++);
            track.play();

        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String BlankBox = " - [   ]";

//        1. CD - [Title] - [category] - [Director] - [Length]: [Price] - [artist]$
//        IF parameter is uninitialized-> append a blank box ?? sb.append(BlankBox)
        sb.append("CD");
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
        if(getArtist()==null || getArtist().isEmpty()){
            sb.append(BlankBox);
        }else{
            sb.append(" - [").append(getArtist()).append("]");
        }

        return sb.toString();
    }

}
