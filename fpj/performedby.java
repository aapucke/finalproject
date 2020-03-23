package com.finalProject.fpj;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class performedby {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int performedbyID;
    private int artistID;
    private int songID;
    private int albumID;
    
    
    
    
    public int getPerformedByID() {
        return this.performedbyID;
    }
    
   
    public void setPerformedByID(int performedbyID) {
        this.performedbyID = performedbyID;
    }
    
   
    public int getArtistID() {
        return this.artistID;
    }
    
  
    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }
    
  
    public int getSongID() {
        return this.songID;
    }
    
   
    public void setSongID(int songID) {
        this.songID = songID;
    }
    
  
    public int getAlbumID() {
        return this.albumID;
    }
    
   
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
}
