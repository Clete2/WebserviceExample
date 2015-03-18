package com.clete2.example.service;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CXFConfiguration {
	@Autowired
	private Bus cxfBus;

	@Autowired
	private PeopleService peopleService;
	
	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		ServletRegistrationBean cxfServletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
		cxfServletRegistrationBean.setLoadOnStartup(1);
		return cxfServletRegistrationBean;
	}
	
	@Bean
	public Endpoint peopleService() {
		EndpointImpl endpoint = new EndpointImpl(cxfBus, peopleService);
		endpoint.publish("/peopleService");
		return endpoint;
	}
}
