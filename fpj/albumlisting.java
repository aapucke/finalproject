package com.finalProject.fpj;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class albumlisting {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumlistingID;
    private int albumID;
    private int songID;
    private int artistID;
    
    
    
   
    public int getalbumlistingID() {
        return this.albumlistingID;
    }
    
  
    public void setalbumlistingID(int albumlistingID) {
        this.albumlistingID = albumlistingID;
    }
    
   
    public int songID() {
        return this.songID;
    }
    
   
    public void setSongID (int songID) {
        this.songID = songID;
    }
    
   
    public void setalbumID (int albumID) {
        this.albumID = albumID;
    }
    public int albumID() {
    	return this.albumID;
    }
    
    public int artistID() {
        return this.artistID;
    }
    
   
    public void setartistID (int artistID) {
        this.artistID = artistID;
    }
    
}
