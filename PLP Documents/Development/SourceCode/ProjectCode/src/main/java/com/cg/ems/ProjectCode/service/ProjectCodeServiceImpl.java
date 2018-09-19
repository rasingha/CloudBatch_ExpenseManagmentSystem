package com.cg.ems.ProjectCode.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.ProjectCode.entity.ProjectCodeBean;
import com.cg.ems.ProjectCode.exception.ProjectCodeException;
import com.cg.ems.ProjectCode.repository.IProjectCodeDAO;


@Service
public class ProjectCodeServiceImpl{
	
	@Autowired
	private IProjectCodeDAO projectDao;
	
	//---------------------------------------- EMS:Project Code Module---------------------------------------------------
	/***************************************************************************************************************************
	 - Function Name	:	addProjectCode
	 - Input Parameters	:	ProjectCodeBean object
	 - Return Type		:	ProjectCodeBean object
	 - Throws			:  	ProjectCodeException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	31/08/2018
	 - Description		:	adding project code details to database calls dao method save(ProjectCodeBean project)
	 ***************************************************************************************************************************/
	
	@Transactional
	public ProjectCodeBean addProjectCode(ProjectCodeBean project){
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate= LocalDate.parse(project.getStartDate(),formatter);
		LocalDate endDate= LocalDate.parse(project.getEndDate(),formatter);
		if(!startDate.isBefore(endDate))
			throw new ProjectCodeException("Start Date should be before End date!");
		return projectDao.save(project); 
	}
	
	//---------------------------------------- EMS:Project Code Module---------------------------------------------------
	/****************************************************************************************************************************
	 - Function Name	:	updateProjectCode
	 - Input Parameters	:	ProjectCodeBean object
	 - Return Type		:	ProjectCodeBean object
	 - Throws			:  	ProjectCodeException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	31/08/2018
	 - Description		:	updating project code details to database calls dao method save(ProjectCodeBean project)
	 * @return 
	 *****************************************************************************************************************************/
	
	@Transactional
	public ProjectCodeBean updateProjectCode(ProjectCodeBean project){
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate= LocalDate.parse(project.getStartDate(),formatter);
		LocalDate endDate= LocalDate.parse(project.getEndDate(),formatter);
		if(!startDate.isBefore(endDate))
			throw new ProjectCodeException("Start Date should be before End date!");
		return projectDao.save(project); 
	}
	
	//---------------------------------------- EMS:Project Code Module---------------------------------------------------
	/*******************************************************************************************************************
	 - Function Name	:	deleteProjectCodeById
	 - Input Parameters	:	int projectId
	 - Return Type		:	void
	 - Throws			:  	-
	 - Author			:	CAPGEMINI
	 - Creation Date	:	31/08/2018
	 - Description		:	deleting project code from database calls dao method deleteById(int projectId)
	 * @return 
	 *******************************************************************************************************************/
	
	@Transactional
	public void deleteProjectCodeById(int projectId){
		
		if(viewProjectCodeById(projectId)==null)
			throw new ProjectCodeException("Project code not found");
		projectDao.deleteById(projectId);
	}

	//---------------------------------------- EMS:Project Code Module---------------------------------------------------
	/***********************************************************************************************************************
	 - Function Name	:	viewProjectCodeById
	 - Input Parameters	:	int projectId
	 - Return Type		:	ProjectCodeBean object
	 - Throws		    :  	-
	 - Author		    :	CAPGEMINI
	 - Creation Date	:	31/08/2018
	 - Description		:	for viewing project code details based on projectId calls dao method findById(projectId)
	 ***********************************************************************************************************************/
	
	public ProjectCodeBean viewProjectCodeById(int projectId){
		
		return projectDao.findById(projectId).get();
	}

	//---------------------------------------- EMS:Project Code Module---------------------------------------------------
	/*******************************************************************************************************
	 - Function Name	: viewAllProjectCode
	 - Input Parameters	:	
	 - Return Type		: List<ProjectCodeBean>
	 - Throws		    : ProjectCodeException
	 - Author	      	: CAPGEMINI 
	 - Creation Date	: 31/08/2018
	 - Description		: for viewing all project code details calls dao method findAll()
	 ********************************************************************************************************/
	public List<ProjectCodeBean> viewAllProjectCode(){
	
		List<ProjectCodeBean> projectList=projectDao.findAll();
		
		return projectList;
	}
	
}