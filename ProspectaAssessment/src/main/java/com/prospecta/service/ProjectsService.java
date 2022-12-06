package com.prospecta.service;

import java.util.List;

import com.prospecta.exceptions.ProjectsException;
import com.prospecta.models.Projects;
import com.prospecta.models.ProjectsDTO;

public interface ProjectsService {

	public List<ProjectsDTO> projectByCategory(String category) throws ProjectsException;
	public Projects addProject(Projects user) throws ProjectsException;
	
}
