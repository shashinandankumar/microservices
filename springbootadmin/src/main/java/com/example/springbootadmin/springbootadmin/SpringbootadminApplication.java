package com.example.springbootadmin.springbootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import de.codecentric.boot.admin.server.config.EnableAdminServer;



@SpringBootApplication
@EnableAdminServer
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringbootadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootadminApplication.class, args);
	}
	@Configuration
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
            http.logout().logoutUrl("/logout");
            http.csrf().disable();

            http.authorizeRequests().antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**").permitAll();
            http.authorizeRequests().antMatchers("/**").authenticated();

            http.httpBasic();
        }
        
        @Bean
        public AuthenticationManager customAuthenticationManager() throws Exception {
          return authenticationManager();
        }
    }
}
