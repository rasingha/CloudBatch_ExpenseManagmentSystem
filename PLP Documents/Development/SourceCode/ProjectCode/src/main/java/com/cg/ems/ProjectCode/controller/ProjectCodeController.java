package com.cg.ems.ProjectCode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.ProjectCode.entity.ProjectCodeBean;
import com.cg.ems.ProjectCode.exception.ProjectCodeException;
import com.cg.ems.ProjectCode.service.ProjectCodeServiceImpl;


@RestController
@RequestMapping("/api")
public class ProjectCodeController {

	@Autowired
	ProjectCodeServiceImpl projectService;
	
	
	@GetMapping("/project")
	public List<ProjectCodeBean> viewAllProjectCode() {
		
		List<ProjectCodeBean> lst= projectService.viewAllProjectCode();
		if( lst.isEmpty())
	    {
	    	throw new ProjectCodeException(" No project records exist ");
	    }
		return lst;
	}
	
	@GetMapping("/project/{projectId}")
	public ProjectCodeBean viewProjectCodeById(@PathVariable int projectId) {
		
		ProjectCodeBean project= projectService.viewProjectCodeById(projectId);
		if( project == null)
	    {
	    	throw new ProjectCodeException(" Project Not Found ");
	    }
		return project;
	}
	
	@PostMapping("/project/create")
	public void addProjectCode(@Valid @RequestBody ProjectCodeBean project) {
		
		projectService.addProjectCode(project);
	}
	
	@PutMapping("/project")
	public void updateProjectCode(@Valid @RequestBody ProjectCodeBean project) {
		
		ProjectCodeBean projectCodeBean= projectService.viewProjectCodeById(project.getProjectId());
		if( projectCodeBean == null)
	    {
	    	throw new ProjectCodeException(" Project Not Found ");
	    }
		projectService.updateProjectCode(project);
	}
	
	@DeleteMapping("/project/{projectId}")
	public void deleteProjectCodeById(@PathVariable int projectId) {
		
		ProjectCodeBean project= projectService.viewProjectCodeById(projectId);
		if( project == null)
	    {
	    	throw new ProjectCodeException(" Project Not Found ");
	    }
		projectService.deleteProjectCodeById(projectId);
	}
	
}
