package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private float length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj; // Cast the object to Track
        return title != null && title.equals(track.title) && length == track.length; // Compare title and length
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("Track: " + this.getTitle() + " has no length, cannot play.");
        } else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Length: " + this.getLength());
        }

    }
}
