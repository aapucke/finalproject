package com.finalProject.fpj;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
public interface artistinterface extends CrudRepository <artists,Integer> {
	
	
	@Query(value ="SELECT DISTINCT artists.* FROM artists  where artists.year1stalbum = :year1stalbum",nativeQuery = true)  
		List <artists>artistYear(@Param("year1stalbum") String year1stalbum);
	
	
	@Query(value ="SELECT * FROM artists", nativeQuery = true)
		List<artists>artists(@Param("artist") String artist);

		@Modifying
		@Transactional	
		@Query(value="INSERT INTO artists(artist,year1stalbum) values(:artist,:year1stalbum)", nativeQuery =true)
		void ThisArtist(@Param("artist")String artist, @Param("year1stalbum") int year1stalbum);

}
