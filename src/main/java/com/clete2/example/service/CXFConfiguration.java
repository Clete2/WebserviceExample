package com.clete2.example.service;

import javax.annotation.PostConstruct;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.clete2.example.service.rest.PeopleRESTServiceImpl;
import com.clete2.example.service.soap.PeopleSOAPService;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CXFConfiguration {
	@Autowired
	private Bus cxfBus;

	@Autowired
	private PeopleRESTServiceImpl peopleRESTServiceImpl;

	@Autowired
	private PeopleSOAPService peopleSOAPService;

	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		ServletRegistrationBean cxfServletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/services/*");
		cxfServletRegistrationBean.setLoadOnStartup(1);
		return cxfServletRegistrationBean;
	}

	@Bean
	public Endpoint peopleSOAPService() {
		Endpoint endpoint = new EndpointImpl(cxfBus, peopleSOAPService);
		endpoint.publish("/peopleService");
		return endpoint;
	}

	@PostConstruct
	public void peopleRESTService() {
		JAXRSServerFactoryBean jrssfb = new JAXRSServerFactoryBean();
		jrssfb.setBus(cxfBus);
		jrssfb.setServiceBean(peopleRESTServiceImpl);
		jrssfb.setAddress("/rest/");
		Server server = jrssfb.create();
		server.start();
	}
}
