package com.cg.ems.project_code.ProjectCode;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.ProjectCode.entity.ProjectCodeBean;
import com.cg.ems.ProjectCode.exception.ProjectCodeException;
import com.cg.ems.ProjectCode.repository.IProjectCodeDAO;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectCodeApplicationTests {

	@Autowired
	IProjectCodeDAO projectDao;
	
	@SuppressWarnings("deprecation")
	@Test
	public void contextLoads() {
		
		ProjectCodeBean project=new ProjectCodeBean();
		projectDao.save(project); 
	}
}
