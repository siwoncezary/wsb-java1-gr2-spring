package pl.wsb.wsbspringgr2.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.wsbspringgr2.servlet.*;

@Configuration
public class ServletConfig {

    @Bean
    ServletRegistrationBean<HomeServlet> registerHomeServlet(){
        ServletRegistrationBean<HomeServlet> servlet = new ServletRegistrationBean<HomeServlet>();
        servlet.setServlet(new HomeServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/");
        return  servlet;
    }

    @Bean
    ServletRegistrationBean<HelloServlet> registerHelloServlet(){
        ServletRegistrationBean<HelloServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(new HelloServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/hello");
        return  servlet;
    }

    @Bean
    ServletRegistrationBean<ParameterServlet> registerParameterServlet(){
        ServletRegistrationBean<ParameterServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(new ParameterServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/parameters");
        return  servlet;
    }

    @Bean
    ServletRegistrationBean<CookieServlet> registerCookieServlet(){
        ServletRegistrationBean<CookieServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(new CookieServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/cookie");
        return  servlet;
    }

    @Bean
    ServletRegistrationBean<SessionServlet> registerSessionServlet(){
        ServletRegistrationBean<SessionServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(new SessionServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/login");
        return  servlet;
    }

    @Bean
    ServletRegistrationBean<TaskServlet> registerTaskServlet(){
        ServletRegistrationBean<TaskServlet> servlet = new ServletRegistrationBean<>();
        servlet.setServlet(new TaskServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/todo");
        return  servlet;
    }

}
