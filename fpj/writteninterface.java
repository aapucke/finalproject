package com.finalProject.fpj;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface writteninterface extends CrudRepository <writtenby, Integer> {

	@Modifying
	@Transactional	
	@Query(value="INSERT INTO writtenby(artistID,albumID, songID, Artist) values(:artistID,:albumID, :songID, :Artist)", nativeQuery =true)
	void ThisWriter(@Param("artistID") int artistID, @Param("albumID") int albumID, @Param("songID") int songID, @Param("Artist") String Artist);
	
	@Query(value ="SELECT * FROM writtenby where songID = :songID" ,nativeQuery = true)
			List<writtenby> writerSong(@Param("songID") int songID);
	
}
