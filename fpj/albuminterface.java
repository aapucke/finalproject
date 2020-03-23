package com.finalProject.fpj;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;




@Service
@RepositoryRestResource
public interface albuminterface extends CrudRepository <album, Integer> {

	
	@Query(value ="SELECT DISTINCT album.* FROM album INNER JOIN albumlisting "
			+ "ON album.albumID = albumlisting.albumID "
			+ "join artists on artists.artistID = albumlisting.artistID "
			+ "where artists.artistID = :artistID",nativeQuery = true)
			List <album>artistAlbum(@Param("artistID") int artistID);
			
			
			
	@Query(value ="SELECT DISTINCT album.* FROM album",nativeQuery = true)
			List <album>album(@Param("albums") String albums);
			
			@Modifying
			@Transactional	
			@Query(value="INSERT INTO album(albumTitle,yearReleased,genre) values(:albumTitle,:yearReleased, :genre)", nativeQuery =true)
			void ThisAlbum(@Param("albumTitle")String albumTitle, @Param("yearReleased") int yearReleased, @Param("genre") String genre);
			

			
			

					
	
	
}
