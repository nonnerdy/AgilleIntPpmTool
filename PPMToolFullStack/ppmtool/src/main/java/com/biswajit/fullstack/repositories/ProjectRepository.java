package com.biswajit.fullstack.repositories;

import org.springframework.stereotype.Repository;

import com.biswajit.fullstack.domain.Project;

import org.springframework.data.repository.CrudRepository;;

@Repository
public interface ProjectRepository  extends CrudRepository<Project,Long>{

	Project findByProjectIdentifier(String projectId);
	
}
