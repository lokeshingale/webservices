package com.dev.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.dev.dao.IStudentDao;
import com.dev.dao.StudentDaoImpl;
import com.dev.service.IStudentService;
import com.dev.service.StudentServiceImpl;
@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
	public AppConfig() {
		packages("com.dev");
		register(new AbstractBinder() {
		@Override
		protected void configure() {
		bind(StudentDaoImpl.class).to(IStudentDao.class);
		bind(StudentServiceImpl.class).to(IStudentService.class);
		}
		});
		register(JspMvcFeature.class);
		property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/view");
		}

}
