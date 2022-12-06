package com.prospecta.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prospecta.models.Projects;
import com.prospecta.models.ProjectsDTO;

@Repository
public interface ProjectsDao extends JpaRepository<Projects, Integer> {

	public List<Projects> findByCategory(String category);

	@Query("select new com.prospecta.models.ProjectsDTO(p.title,p.description) from Projects p where name like :nameString")
	public List<ProjectsDTO> findByCategoryString(@Param("nameString") String name);

}
