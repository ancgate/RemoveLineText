/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

import java.util.List;

/**
 *
 * @author jeffersonbienaime
 */
public class Album {
    
    private String albumId;
    private String albumName;
    private List<Track> track;
    private Artist artist;

    public Album(String albumId, String albumName, List<Track> track, Artist artist) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.track = track;
        this.artist = artist;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

   
    
    
   
}
