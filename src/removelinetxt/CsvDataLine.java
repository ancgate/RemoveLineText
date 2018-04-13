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
public class CsvDataLine {
    
    private String link;
    private String idAlbum;

    public CsvDataLine(String link, String idAlbum) {
        this.link = link;
        this.idAlbum = idAlbum;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }
    
    
}
