package controllers;


import model.Playlist;
import model.Track;
import playlistappstarter.InputHelper;


/**
 *
 * @author mga
 */
public class PlaylistController {

    private final Playlist playlist;

    public PlaylistController() {
        InputHelper inputHelper = new InputHelper();
        String playlistName = inputHelper.readString("Enter Playlist Name");
        String playlistAuthor = inputHelper.readString("Enter Playlist Author");

        playlist = new Playlist(playlistName, playlistAuthor);
    }

    public void run() {
        boolean finished = false;
        do {
            System.out.println(playlist);
            char choice = displayPlaylistMenu();
            switch (choice) {
                case 'A':
                    addTrack();
                    break;
                case 'B':
                    deleteTrack();
                    break;
                case 'F':
                    finished = true;
            }
        } while (!finished);
    }

    private char displayPlaylistMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add a new track");
        System.out.print("\tB. Delete a track");
        System.out.print("\tF. Finish\n");
        return inputHelper.readCharacter("Enter choice", "ABF");
    }

    private void addTrack() {
        InputHelper inputHelper = new InputHelper();
        String trackTitle = inputHelper.readString("Enter Track Title");
        String trackArtist = inputHelper.readString("Enter Track Artist");
        int trackMinutes = inputHelper.readInt("Enter Track Minutes", 60, 0);
        int trackSeconds = inputHelper.readInt("Enter Track Seconds", 60, 0);
        Track newTrack = new Track(trackTitle, trackArtist, trackMinutes * 60 + trackSeconds);
        playlist.addTrackToPlaylist(newTrack);
    }

    private void deleteTrack() {
        InputHelper inputHelper = new InputHelper();
         int trackId =  inputHelper.readInt("Enter Track id", 100, 1);
        playlist.removeTrackFromPlaylist(trackId);

    }

}
