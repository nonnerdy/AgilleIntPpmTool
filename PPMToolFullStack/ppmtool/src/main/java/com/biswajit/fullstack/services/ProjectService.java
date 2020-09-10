package com.biswajit.fullstack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.fullstack.domain.Project;
import com.biswajit.fullstack.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project savePrUpdateProject(Project project) {
		//Logic 
		return projectRepository.save(project);
	}
}
