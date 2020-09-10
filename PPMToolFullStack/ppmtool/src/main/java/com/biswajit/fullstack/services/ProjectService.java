package com.biswajit.fullstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.fullstack.domain.Project;
import com.biswajit.fullstack.exception.ProjectIdException;
import com.biswajit.fullstack.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project savePrUpdateProject(Project project) {
		// Logic
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception ex) {
			throw new ProjectIdException(
					"Project Id '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}
	}
	
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException(
					"Project Id '" + projectId + "' doesnot exists");
		}
				
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();		
	}
}
