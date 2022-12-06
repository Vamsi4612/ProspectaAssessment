package com.prospecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.exceptions.ProjectsException;
import com.prospecta.models.Projects;
import com.prospecta.models.ProjectsDTO;
import com.prospecta.repository.ProjectsDao;

@Service
public class ProjectsServiceImpl implements ProjectsService {
	@Autowired
	private ProjectsDao bDao;

	@Override
	public List<ProjectsDTO> projectByCategory(String category) throws ProjectsException {
		if (category != null) {

			List<ProjectsDTO> list = bDao.findByCategoryString("%" + category + "%");
			if (list.size() == 0) {
				throw new ProjectsException("No Projects found with name " + category);
			}

			return list;

		} else {
			throw new ProjectsException("Null values are not accepted");
		}
	}

	@Override
	public Projects addProject(Projects project) throws ProjectsException {
		if (project != null) {
			Projects e = bDao.save(project);
			return e;
		}
		else {
			throw new ProjectsException("Null values are not accepted");
		}
	}
	
}
