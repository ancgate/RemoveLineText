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
public class Track {
    
    private int Trackid;
    private int TrackName;

    public Track(int Trackid, int TrackName) {
        this.Trackid = Trackid;
        this.TrackName = TrackName;
    }

    public int getTrackid() {
        return Trackid;
    }

    public void setTrackid(int Trackid) {
        this.Trackid = Trackid;
    }

    public int getTrackName() {
        return TrackName;
    }

    public void setTrackName(int TrackName) {
        this.TrackName = TrackName;
    }
    
    
}
