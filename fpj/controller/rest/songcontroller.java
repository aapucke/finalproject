package com.finalProject.fpj.controller.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.fpj.album;
import com.finalProject.fpj.albuminterface;
import com.finalProject.fpj.albumlistinginterface;
import com.finalProject.fpj.artistinterface;
import com.finalProject.fpj.artists;
import com.finalProject.fpj.songs;
import com.finalProject.fpj.songsinterface;
import com.finalProject.fpj.writtenby;
import com.finalProject.fpj.writteninterface;
import com.finalProject.fpj.albumlisting;

@RestController
public class songcontroller  {
	@Autowired
	songsinterface songlisting;
	
	@Autowired
	albuminterface albumlist;
	
	@Autowired
	artistinterface artlist;
	@Autowired
	writteninterface writerslist;
	@Autowired
	albumlistinginterface albumlisting;
	
	@GetMapping(value ="/checkon")
	public String hello() {
		return "Hello World ! " ;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/lyrics/songID/{text}")
	public List<songs>lyrics(@PathVariable("text") int songID){
		List<songs> song = songlisting.lyrics(songID);
		return song;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/writer/song/{text}")
	public List<writtenby> writennbySong(@PathVariable("text") int songID) {
	 List<writtenby> song = writerslist.writerSong(songID);
		 
		return song;
		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/songs/count/")
	public Long counter() {
		return songlisting.count();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/artist/songs/{text}")
	public List<songs> titleartist(@PathVariable("text") String songs) {
		List<songs> song = songlisting.titleartist(songs);
		
		return song;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/songs/album/{text}")
	public List <songs> songsAlbum(@PathVariable("text") int songs) {
		List <songs> song = songlisting.songsAlbum(songs);
		
		return song;
	}
	@CrossOrigin(origins="*")
	@GetMapping(value ="/artists/")
	public Iterable<artists> findArtlist(){
	return artlist.findAll();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/albums/")
	public Iterable<album> findAlbumlist(){
	return albumlist.findAll();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value ="/songs/")
	public Iterable<songs> findSongslist(){
	return songlisting.findAll();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value ="/writers/")
	public Iterable<writtenby> findwriterlist(){
	return writerslist.findAll();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value ="/albumlisting/")
	public Iterable<albumlisting> findalbumlistinglist(){
	return albumlisting.findAll();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value ="/albums/artist/{text}")
	public List <album> artistAlbum(@PathVariable("text")int album) {
	List <album> song = albumlist.artistAlbum(album);
		return song;
	}
	/*
	@GetMapping(value ="/albums/year/{text}")
	public List <album> yearAlbum(@PathVariable("text")String year) {
	List <album> song = albumlist.yearAlbum(year);
		return song;
	}
	*/
	@CrossOrigin(origins="*")
	@GetMapping(value ="/songs/year/{text}")
	public List <songs> songsYear(@PathVariable("text") String year) {
		List <songs> song = songlisting.songsYear(year);
		return song;
	}
	@CrossOrigin(origins="*")
	@GetMapping(value = "/year/artist/{text}")
	public List<artists> artlist(@PathVariable("text") String year){
		List<artists> song = artlist.artistYear(year);
		return song;
	}
	/*
	@GetMapping(value ="/allinfo/{text2}/{text3}/{text4}/{text5}/{text6}")
	public List <songs>allInfo(@PathVariable("text2")String lyrics, @PathVariable ("text3")String writer,
			@PathVariable("text4") String album ,@PathVariable ("text5")String artist, @PathVariable("text6") int year){
	List<songs> song = songlisting.allinfo(lyrics, writer, album, artist, year);
	return song;
	}
	
	*/
	@CrossOrigin(origins="*")
	@PostMapping(value="/newsong/")
	@ResponseBody
	public void Post(@RequestParam("songTitle")String songTitle,@RequestParam("yearReleased") int yearReleased, @RequestParam("songLyrics") String songLyrics) {
		 songlisting.ThisSong(songTitle, yearReleased, songLyrics);
		}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/newalbumlisting/")
	@ResponseBody
	public void Post(@RequestParam("artistID")int artistID, @RequestParam("albumID") int albumID,@RequestParam("songID") int songID)  {
		 albumlisting.ThisAL(artistID, albumID, songID);
		}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/newartist/")
	@ResponseBody
	public void Post(@RequestParam("artist")String artist,@RequestParam("year1stalbum") int year1stalbum) {
		 artlist.ThisArtist(artist, year1stalbum);
		}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/newalbum/")
	@ResponseBody
	public void PostAlbum(@RequestParam("albumTitle")String albumTitle,@RequestParam("yearReleased") int yearReleased, @RequestParam("genre") String genre) {
		 albumlist.ThisAlbum(albumTitle, yearReleased, genre);
		}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/newwriters/")
	@ResponseBody
	public void PostWriter(@RequestParam("artistID") int artistID, @RequestParam("albumID") int albumID, @RequestParam("songID") int songID, @RequestParam("artist") String artist)  {
		 writerslist.ThisWriter(artistID, albumID, songID, artist);
		}
	
	@CrossOrigin(origins="*")
	@PutMapping(value = "/updatesong/{yearReleased}/{songID}")
	@ResponseBody
	public int updatesong(@PathVariable("yearReleased") int yearReleased, @PathVariable("songID") int songID) {
		 int song = songlisting.songupdate(yearReleased, songID);
		 return song;
		
	}
	/*
	@CrossOrigin(origins="*")
	@DeleteMapping(value ="/deletealbumlisting/{id}")
	@ResponseBody
	public void deleteAlbListing(@RequestParam("artistID") int artistID, @RequestParam("albumID") int albumID, @RequestParam("songID") int songID,@RequestParam("albumlistingID") int albumlistingID){
		//int  = albumlisting.deleteByalbumlistingID(albumlistingID);
		albumlisting.deleteAlbumListing(artistID, albumID, songID, albumlistingID);
		//assertThat(albumlisting.count()).isEqualTo(1);
		}
		 */
	
	
}
