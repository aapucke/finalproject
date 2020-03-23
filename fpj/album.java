package com.finalProject.fpj;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer albumID;
    private String albumtitle;
    private Integer yearreleased;
    
  
    public Integer getYearReleased() {
        return this.yearreleased;
    }
    
   
    public void setYearReleased(Integer yearReleased) {
        this.yearreleased = yearReleased;
    }
    
  
    public String getAlbumTitle() {
        return this.albumtitle;
    }
    
    
    public void setAlbumTitle(String albumTitle) {
        this.albumtitle = albumTitle;
    }
    
  
    public Integer getAlbumID() {
        return this.albumID;
    }
    
   
    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }
    

}
