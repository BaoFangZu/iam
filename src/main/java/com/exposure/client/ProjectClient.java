package com.exposure.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposure.model.Project;

@RequestMapping(value = "/api",produces = "application/json")
@FeignClient(name="project-service", fallback = HystrixPorjectClient.class) 
public interface ProjectClient {
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = "application/json")
	public List<Project> findProjects(@RequestParam("userId") long id);

}

@Component
class HystrixPorjectClient implements ProjectClient{
	@RequestMapping(value = "/xxx/ooo")
	public List<Project> findProjects(long id) {
		// TODO Auto-generated method stub
		List<Project> projects = new ArrayList<Project>();
		Project project = new Project();
		project.setId(0);
		project.setName("fallback");
		project.setDescription("fallback desc");
		projects.add(project);
		return projects;
	}

}