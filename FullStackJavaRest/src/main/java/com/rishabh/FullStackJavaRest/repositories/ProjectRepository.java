package com.rishabh.FullStackJavaRest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.FullStackJavaRest.Model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	Project findByProjectIdentifier(String projectId);
	@Override
	 Iterable<Project> findAll();

		
	

	
	
//	@Override
//	Iterable<Project> findAllById(Iterable<Long> iterable);
	

}
