package com.finalProject.fpj;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class writtenby {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int writtenbyID;
    private int artistID;
    private int songID;
    private String Artist;
    private int albumID;
    
    
    
   
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
    
    
    public int getWrittenByID() {
        return this.writtenbyID;
    }
    
   
    public void setWrittenByID(int writtenByID) {
        this.writtenbyID = writtenByID;
    }
    
 
    public String getArtist() {
        return this.Artist;
    }
    
  
    public void setArtist(String Artist) {
        this.Artist = Artist;
    }
    
   
    public Integer getAlbumID() {
        return this.albumID;
    }
    
 
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
}

