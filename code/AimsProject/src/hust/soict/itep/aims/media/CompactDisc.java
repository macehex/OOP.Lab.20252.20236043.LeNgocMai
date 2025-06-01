package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String title;
    private String category;

    private float cost;
    private float length;
    private String artist;
    private Track[] tracks = new Track[100];



    public CompactDisc(int id, String title, String category, float cost, float length, String artist) throws AimsException {
        super(id, title, category, cost);
        this.length = length;
        this.artist = artist;
    }

    public void addTrack(Track track) {
        for (Track existingTrack:tracks) {
            if (existingTrack != null && existingTrack.getTitle().equals(track.getTitle())) {
                System.out.println("Track already exists: " + track.getTitle());
                return;
            }
        }
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] == null) {
                tracks[i] = track;
                System.out.println("Track added: " + track.getTitle());
                return;
            }
        }
        System.out.println("Track list is full. Cannot add track: " + track.getTitle());
    }
    public void removeTrack(Track track) {
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] != null && tracks[i].getTitle().equals(track.getTitle())) {
                tracks[i] = null;
                System.out.println("Track removed: " + track.getTitle());
                return;
            }
        }
        System.out.println("Track not found: " + track.getTitle());
    }
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            if (track != null) {
                totalLength += (int) track.getLength();
            }
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("CD length is invalid!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                // Log the error but continue playing other tracks
                System.err.println("Error playing track: " + e.getMessage());
            }
        }
    }
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getLength() + " - " + getCost();
    }
}
