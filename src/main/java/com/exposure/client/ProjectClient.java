package com.exposure.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposure.model.Project;

@RequestMapping(value = "/api",produces = "application/json")
@FeignClient("project-service") 
public interface ProjectClient {
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = "application/json")
	public List<Project> findProjects(@RequestParam("userId") long id);

}
