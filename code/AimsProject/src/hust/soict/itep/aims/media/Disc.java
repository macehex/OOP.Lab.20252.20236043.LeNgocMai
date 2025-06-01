package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.AimsException;

public class Disc extends Media {

    private String director;
    private int length;
    public Disc(int id, String title, String category, float cost) throws AimsException {
        super(id, title, category, cost);


    }

    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }

}