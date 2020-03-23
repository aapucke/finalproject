package com.finalProject.fpj;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class songs {
	    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int songID;
	 private String songtitle;
	 private int yearreleased;
	 private String songlyrics;
	    


		public int getSongID() {
	        return this.songID;
	    }
	    
	  
	    public void setSongID(Integer songID) {
	        this.songID = songID;
	    }
	   
	    
	    
	    public String getSongTitle() {
	        return this.songtitle;
	    }
	    
	 
	    public void setSongTitle(String songTitle) {
	        this.songtitle = songTitle;
	    }
	    
	 
	    public int getYearReleased() {
	        return this.yearreleased;
	    }
	    
	  
	    public void setYearReleased(int yearReleased) {
	        this.yearreleased = yearReleased;
	    }
	    
	
	    public String getSongLyrics() {
	        return this.songlyrics;
	    }
	    
	 
	    public void setSongLyrics(String songLyrics) {
	        this.songlyrics = songLyrics;
	    }
	    
	 
	
	    
}


