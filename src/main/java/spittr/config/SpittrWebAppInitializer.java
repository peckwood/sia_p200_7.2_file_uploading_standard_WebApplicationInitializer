package spittr.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpittrWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext webApplicationContext = getContext();
		// ContextLoaderListener is added to ServletContext –
		// the purpose of this is to 'glue' WebApplicationContext
		// to the lifecycle of ServletContext
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dispatcherServlet.setLoadOnStartup(1);
		//original project used "/*" and didn't work for "/" requests
		dispatcherServlet.addMapping("/");
		
		dispatcherServlet.setMultipartConfig(new MultipartConfigElement("D:/d/data/temp/upload"));
		
		//more complete configuration
		//upload location, max file size in bytes, max request size, max file size to not write to location
		//no default, no limit, no limit, 0
		/*dispatcherServlet.setMultipartConfig(new MultipartConfigElement("D:/d/data/temp/upload", 2*1024*1024, 4*1024*1024, 0));*/
		
		
	}

	private AnnotationConfigWebApplicationContext getContext() {
		/*
		 * AnnotationConfigWebApplicationContext is created. It's
		 * WebApplicationContext implementation that looks for Spring
		 * configuration in classes annotated with @Configuration annotation.
		 * setConfigLocation() method gets hint in which package(s) to look for
		 * them.
		 */
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("spittr.config");
		return context;
	}

}
