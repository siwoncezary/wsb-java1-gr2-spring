package pl.wsb.wsbspringgr2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .realmName("Realm")
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/todos/**").hasRole("USER")
                .antMatchers("/todo/add").hasRole("USER")
                .anyRequest().permitAll()
                .and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("$2y$12$AJPlrAl.J0QRLio/eDQ0auQ4yLtF5a8Dx66VMwAewIwaINzqGGHJe").roles("USER")
                .and()
                .withUser("admin").password("$2y$12$AJPlrAl.J0QRLio/eDQ0auQ4yLtF5a8Dx66VMwAewIwaINzqGGHJe").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

