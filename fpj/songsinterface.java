package com.finalProject.fpj;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;




@RepositoryRestResource
public interface songsinterface extends CrudRepository <songs, Integer> {
	

	@Query(value ="SELECT songs.* FROM songs WHERE songID = :songID", nativeQuery = true)
	List<songs> lyrics(@Param("songID")int songID);
	
	@Query(value ="select S.* from songs s\r\n" + 
			"join albumlisting al on al.songID = s.songID\r\n" + 
			"join album on album.albumID = al.albumID\r\n" + 
			"where album.albumID = :albumID", nativeQuery = true)
	List <songs>songsAlbum(@Param ("albumID")int albumID);
			
	@Query(value ="SELECT Songs.* FROM Songs "
			+ "INNER JOIN albumListing ON Songs.songID = albumListing.songID join "
			+ " album on  album.albumID=albumListing.albumID"
			+ " where album.yearReleased = :yearReleased", nativeQuery = true)
	List <songs>songsYear(@Param ("yearReleased")String yearReleased);
			
			
	@Query(value = "SELECT songs.* FROM songs INNER JOIN albumListing "
			+ "ON songs.songID = albumListing.songID join artists "
			+ "on artists.artistID = albumListing.artistID"
			+ " where artists.artist = :artist", nativeQuery = true)
		List<songs>titleartist(@Param ("artist")String artist);
	
	@Modifying
	@Transactional	
	@Query(value="INSERT INTO songs(songTitle,yearReleased,songLyrics) values(:songTitle,:yearReleased,:songLyrics)", nativeQuery =true)
	void ThisSong(@Param("songTitle")String songTitle, @Param("yearReleased") int yearReleased, @Param("songLyrics") String songLyrics);
	
	@Modifying
	@Transactional	
	@Query(value= "UPDATE songs SET yearReleased  =  :yearReleased where songID = :songID)", nativeQuery = true)
	 int songupdate( @Param("yearReleased") int yearReleased, @Param("songID") int songID);
	



	
	/*

	
	@Query(value = "SELECT songs.*, writtenby.*, album.*, artists.* FROM songs INNER JOIN writtenby"
			+ " ON songs.songID = writtenby.songID join albumlisting on albumlisting.songID = songs.songID"
			+ "join album on album.albumID= albumlisting.albumID "
			+ "join artists on artists.artistID = albumlisting.artistID"
			+ "where songs.songTitle = :songTitle",nativeQuery = true)
			List <songs>allinfo(@Param("lyrics")String lyrics, @Param ("writer")String writer,
	@Param("album") String album ,@Param ("artist")String artist, @Param("year") int year);

			@Query(value = "SELECT songs.songLyrics, writtenby.Artist, songs.songTitle, artists.artist,\r\n" + 
					"			album.yearReleased FROM songs INNER JOIN writtenby ON songs.songID = writtenby.songID \r\n" + 
					"			join albumlisting on albumlisting.songID = songs.songID\r\n" + 
					"			join album on album.albumID= albumlisting.albumID\r\n" + 
					"			join artists on artists.artistID = albumlisting.artistID\r\n" + 
					"			where album.albumTitle = :albumTitle", nativeQuery = true)



			@Query(value = "SELECT songs.songID,songs.songTitle, songs.songLyrics, writtenby.artist, album.albumTitle,album.yearReleased,album.genre FROM songs INNER JOIN albumlisting ON songs.songID = albumlisting.songID "
					+ "join writtenby on writtenby.songID = songs.songID "
					+ "join album on album.albumID= albumlisting.albumID "
					+ "join artists on artists.artistID = albumlisting.artistID where artists.artist = ", nativeQuery = true)
	*/
	
	
}
