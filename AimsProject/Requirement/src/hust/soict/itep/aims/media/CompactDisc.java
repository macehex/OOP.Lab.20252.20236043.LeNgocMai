package hust.soict.itep.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String artist) {
        super(id, title);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, double cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, String director, int length, double cost, String artist) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
    }
//    public CompactDisc(int id, String title, String director, int length, String artist) {
//        super(id, title, director, length);
//        this.artist = artist;
//    }

    public CompactDisc(int id, String title, String category, String director, float cost, String artist) {
        super(id, title, category, director, cost);
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
}
