package com.rishabh.FullStackJavaRest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rishabh.FullStackJavaRest.Model.Project;
import com.rishabh.FullStackJavaRest.exception.ProjectIDException;
import com.rishabh.FullStackJavaRest.repositories.ProjectRepository;

@Service
public class ProjectService {
@Autowired
private ProjectRepository projectRepository;

public Project saveOrUpdateProject(Project project) {
	try {
		//project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
		return projectRepository.save(project);
	}
	catch(Exception e) {
		throw new ProjectIDException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exist");
	}
	}
      public Project findProjectByIdentifier(String projectId) {
    	  Project project = projectRepository.findByProjectIdentifier(projectId);
    	  if(project == null) {
    		  throw new ProjectIDException("Project ID '"+projectId+"' Does Not exist");
    	  }
    	  return project;
      }
     public Iterable<Project> findAllProject(){
    	 return projectRepository.findAll();
     }
     public void deleteProjectByIdentifier(String projectId){
    	 Project project = projectRepository.findByProjectIdentifier(projectId);
    	 if(project==null) {
    		 throw new ProjectIDException("cannot project ID'"+projectId+"'.this project does not Exist");
    	 }
    	 projectRepository.delete(project);
     }
     
       
}
