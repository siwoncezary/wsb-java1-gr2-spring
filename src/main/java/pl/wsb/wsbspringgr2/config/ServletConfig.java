package pl.wsb.wsbspringgr2.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.wsbspringgr2.servlet.HelloServlet;
import pl.wsb.wsbspringgr2.servlet.HomeServlet;
import pl.wsb.wsbspringgr2.servlet.ParameterServlet;

@Configuration
public class ServletConfig {

    @Bean
    ServletRegistrationBean<HomeServlet> registerHomeServlet(){
        ServletRegistrationBean<HomeServlet> servlet = new ServletRegistrationBean<HomeServlet>();
        servlet.setServlet(new HomeServlet());
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/","/home");
        return  servlet;
    }
    //Zarejestrować serwlet działający pod url: /hello drukujący komunikat "Hello"
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

}
