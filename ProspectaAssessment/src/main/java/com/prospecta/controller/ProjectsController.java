package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.exceptions.ProjectsException;
import com.prospecta.models.Projects;
import com.prospecta.models.ProjectsDTO;
import com.prospecta.service.ProjectsService;

@RestController
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;
	
	@GetMapping("/entries")
	public ResponseEntity<List<ProjectsDTO>> getProjectByCategoryHandler(@RequestParam String category) throws ProjectsException {
		List<ProjectsDTO> list = projectsService.projectByCategory(category);
		return new ResponseEntity<List<ProjectsDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/addEntry")
	public ResponseEntity<Projects> saveBook(@RequestBody Projects book) throws ProjectsException {
		return new ResponseEntity<Projects>(projectsService.addProject(book),HttpStatus.ACCEPTED);
	}
	
}
