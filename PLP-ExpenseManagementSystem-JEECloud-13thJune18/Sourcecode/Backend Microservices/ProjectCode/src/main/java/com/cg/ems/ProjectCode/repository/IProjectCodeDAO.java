package com.cg.ems.ProjectCode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ems.ProjectCode.entity.ProjectCodeBean;


public interface IProjectCodeDAO extends JpaRepository<ProjectCodeBean, Integer> 
{
	
}
