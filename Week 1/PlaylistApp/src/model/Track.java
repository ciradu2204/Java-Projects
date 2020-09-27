/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public class Track {
    private final int trackId;
    private String trackTitle;
    private String trackArtist;
    private int trackLength;
    
    private static int lastAllocatedTrackId = 0;
    
    public Track() {

        this.trackId = ++lastAllocatedTrackId;
    }
    
    public Track(String trackTitle, String trackArtist, int trackLength) {
        this.trackId = ++lastAllocatedTrackId;
        this.trackTitle = trackTitle;
        this.trackArtist = trackArtist;
        this.trackLength = trackLength;
    }

     public Track(int trackId, String trackTitle, String trackArtist, int trackLength){

        this.trackId = getLastAllocatedTrackId();
        this.trackTitle = trackTitle;
        this.trackArtist = trackArtist;
        this.trackLength = trackLength;

         if (trackId > lastAllocatedTrackId)
            lastAllocatedTrackId = trackId;

    }


    public static int getLastAllocatedTrackId() {
        return lastAllocatedTrackId;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public static void setLastAllocatedTrackId(int lastAllocatedTrackId) {
        Track.lastAllocatedTrackId = lastAllocatedTrackId;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public int getTrackId() {
        return this.trackId;
    }
    
    public String getTrackTitle() {
        return this.trackTitle;
    }
    
    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    // Hint: add getters and setters
    
    
    private int getTrackLengthMinutes() {
        return this.trackLength/60;
    }
    
    private int getTrackLengthSeconds() {
        return this.trackLength % 60;
    }
    
    @Override
    public String toString() {
        return "\nId: " + Integer.toString(this.trackId) +
                " Title: " + this.trackTitle +
                " Artist: " + this.trackArtist +
                " Length: " + Integer.toString(getTrackLengthMinutes()) + ":" + Integer.toString(getTrackLengthSeconds()) + "\n";
    }
}
