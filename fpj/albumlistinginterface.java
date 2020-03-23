package com.finalProject.fpj;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface albumlistinginterface extends CrudRepository <albumlisting, Integer> {

	
	@Modifying
	@Transactional	
	@Query(value="INSERT INTO albumlisting(artistID,albumID, songID) values(:artistID,:albumID, :songID)", nativeQuery =true)
	void ThisAL(@Param("artistID") int artistID, @Param("albumID") int albumID, @Param("songID") int songID);
	
	@Query(value ="SELECT * FROM albumlisting",nativeQuery = true)
	List <albumlisting>albumlisting(@Param("albumlisting") String albumlisting);
	
	
	//@Modifying
	//@Transactional
	//public void
	/*
	@Query(value ="DELETE [artistID], [albumID], [songID] FROM albumlisting where albumlistingID = :albumlistingID", nativeQuery = true)
	void deleteAlbumListing(@Param("artistID") int artistID, @Param("albumID") int albumID, @Param("songID") int songID, @Param("albumlistingID") int albumlistingID );

		*/
	
	
	
}
