package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable {

    private String title;
    private String category;
    private String director;
    private int cost;
    private float length;

    public int id;
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) throws AimsException {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }


    public String getDirector() {
        return director;
    }
    public int getLength() {
        return (int) length;
    }


    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + this.getLength() + " - " +getCost();
    }
    @Override
    public void play() throws PlayerException {
        if (getLength() < 0) {
            throw new PlayerException("DVD: " + getTitle() + " has no length, cannot play.");
        } else {
            String message = "Playing DVD: " + getTitle() + "\nLength: " + getLength();
            JOptionPane.showMessageDialog(null, message, "Now Playing", JOptionPane.INFORMATION_MESSAGE);
        }
    }    @Override
    public int compareTo(Media o) {
        if (o instanceof DigitalVideoDisc) {
            DigitalVideoDisc other = (DigitalVideoDisc) o;
            //compare by title first
            int titleComparison = this.getTitle().compareTo(other.getTitle());
            if(titleComparison == 0) {
                // then decreasing length
                int lengthComparison = Integer.compare((int) other.getLength(), (int) this.getLength());
                // then cost
                if(lengthComparison == 0) {
                    return Float.compare(this.getCost(), other.getCost());
                } else {
                    return lengthComparison;
                }
            }
            else {
                return titleComparison;
            }
        }
        return 0;
    }

}
