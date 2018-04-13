/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removelinetxt;

/**
 *
 * @author jeffersonbienaime
 */
public class InfoFile {
    
    private String artist;
    private String album;

    public InfoFile(String artist, String album) {
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    
    
}
