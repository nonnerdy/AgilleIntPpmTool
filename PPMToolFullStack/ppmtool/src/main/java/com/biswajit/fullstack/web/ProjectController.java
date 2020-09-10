package com.biswajit.fullstack.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.fullstack.domain.Project;
import com.biswajit.fullstack.services.MapValidationErrorService;
import com.biswajit.fullstack.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService mapValidationService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result) throws Exception{
		
		ResponseEntity<?> errorMap = mapValidationService.MapValidationService(result);
		if(errorMap!=null) return errorMap;
		Project project1 = projectService.savePrUpdateProject(project);
		
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	}
}
