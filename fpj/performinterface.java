package com.finalProject.fpj;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface performinterface extends CrudRepository <performedby, Integer> {

}
