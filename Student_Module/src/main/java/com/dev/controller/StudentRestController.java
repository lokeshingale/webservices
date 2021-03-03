package com.dev.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import com.dev.dto.StudentDTO;
import com.dev.service.IStudentService;

@Path("/reg")
public class StudentRestController {
	@Inject
	private IStudentService service;
	
	@GET
	@Path("/register")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable showForm() {
		return new Viewable("/save");
	}
	@POST
	@Path("/saveForm")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Viewable saveForm(
			@FormParam("name") String name,
			@FormParam("dob") String dob,
			@FormParam("doj") String doj
			) {
		int res=0;
		Map<String, String> map=new HashMap<>();
		StudentDTO dto=new StudentDTO();
		dto.setName(name); 
	//	dto.setDob(java.time.LocalDate.parse(dob));
		//dto.setDoj(java.time.LocalDate.parse(doj));
		try {
			res=service.regStudent(dto);
			if(res==1) {
			map.put("message", "student is saved..");
			}
			else {
				map.put("message", "student is not saved..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Viewable("/save",map);
	}
	@GET
	@Path("/all")
	@Produces(MediaType.TEXT_HTML)
	public Viewable getList(HttpServletRequest request) throws Exception {
		Map<String, Object> map=new HashMap<>();
			List<StudentDTO> listDto = null;
				listDto = service.getStudentList();
					map.put("listDto", listDto);
				return new Viewable("/get_list", map);
		
	}
}
