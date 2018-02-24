package ru.kpfu.springwebmvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * 
 * Initializer of web-application. See
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-container-config
 * 
 * Code for studying purposes.
 * Programming course. Kazan Federal University, ITIS.
 * http://study.istamendil.info/
 *
 * @author Alexander Ferenets <istamendil.info>
 */
public class WebInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext){

    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.getEnvironment().setActiveProfiles("live");
    context.register(WebConfig.class);
    context.setServletContext(servletContext);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);

  }


}
