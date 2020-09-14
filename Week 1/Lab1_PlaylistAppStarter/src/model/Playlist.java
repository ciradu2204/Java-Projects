package model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Playlist  {

    private String playlistName;
    private String playListAuthor;
    private ArrayList<Track> playlistTracks;


    public Playlist(){
        this.playlistName = "New Playlist";
        this.playListAuthor = "Unknown";
        this.playlistTracks = new ArrayList<Track>();
    }

    public Playlist(String playlistName, String playListAuthor){

        this.playlistName = playlistName;
        this.playListAuthor = playListAuthor;
        this.playlistTracks = new ArrayList<Track>();
    }

    public Playlist(String playlistName, String playListAuthor, ArrayList<Track> playlistTracks ){
        this.playlistName = playlistName;
        this.playListAuthor = playListAuthor;
        this.playlistTracks = playlistTracks;
    }

    public String getPlayListAuthor() {
        return playListAuthor;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlayListAuthor(String playListAuthor) {
        this.playListAuthor = playListAuthor;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void setPlaylistTracks(ArrayList<Track> playlistTracks) {
        this.playlistTracks = playlistTracks;
    }

    public ArrayList<Track> getPlaylistTracks() {
        return playlistTracks;
    }

    private String getNumberedTracks(){
        String numberedTracks = "\n";
        int number = 1;
        for(Track track: this.playlistTracks){
            numberedTracks += Integer.toString(number++) + ": " + track.toString() + "\n";
        }

        return numberedTracks;
    }

    public void addTrackToPlaylist(Track track){

        this.playlistTracks.add(track);

    }


    public void removeTrackFromPlaylist(int trackId) {

//        Predicate<Track> trackPredicate =
//                t-> t.getTrackId() == trackId;
//        this.playlistTracks.removeIf(trackPredicate);

        for(int i= 0; i<playlistTracks.size(); i++){

            if(playlistTracks.get(i).getTrackId() == trackId){

                playlistTracks.remove(playlistTracks.get(i));

            }
        }

    }

}
