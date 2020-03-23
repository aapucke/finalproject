package com.finalProject.fpj;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class artists {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistID;
    private String artist;
    private int year1stalbum;
    
    
    public int getArtistID() {
        return this.artistID;
    }
    
    
    public void setArtistID(Integer artistID) {
        this.artistID = artistID;
    }
    
   
    public String getArtist() {
        return this.artist;
    }
    
   
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    
    public Integer getYear1stalbum() {
        return this.year1stalbum;
    }
    
   
    public void setYear1stalbum(Integer year1stalbum) {
        this.year1stalbum = year1stalbum;
    }
    
}
