package com.clete2.example.service;

import java.util.Arrays;

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
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.clete2.example.service.rest.JobRESTService;
import com.clete2.example.service.rest.PeopleRESTService;
import com.clete2.example.service.soap.SOAPService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CXFConfiguration {
	@Autowired
	private Bus cxfBus;

	@Autowired
	private PeopleRESTService peopleRESTService;
	
	@Autowired
	private JobRESTService jobRESTService;

	@Autowired
	private SOAPService soapService;

	@Bean
	public ServletRegistrationBean cxfServletRegistrationBean() {
		ServletRegistrationBean cxfServletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/*");
		cxfServletRegistrationBean.setLoadOnStartup(1);
		return cxfServletRegistrationBean;
	}

	@Bean
	public Endpoint soapService() {
		Endpoint endpoint = new EndpointImpl(cxfBus, soapService);
		endpoint.publish("/soapService");
		return endpoint;
	}

	@PostConstruct
	public void restService() {
		JAXRSServerFactoryBean jrssfb = new JAXRSServerFactoryBean();
		jrssfb.setBus(cxfBus);
		jrssfb.setServiceBeans(Arrays.asList(new Object[] { peopleRESTService, jobRESTService }));
		jrssfb.setAddress("/restService");
		
		JacksonJaxbJsonProvider jaxbJsonProvider = new JacksonJaxbJsonProvider();
		ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().featuresToEnable(SerializationFeature.INDENT_OUTPUT).build();
		jaxbJsonProvider.setMapper(mapper);
		
		jrssfb.setProvider(jaxbJsonProvider);
		Server server = jrssfb.create();
		server.start();
	}
}
