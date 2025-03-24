package com.luv2code.springboot.demoSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class security {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource data){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(data);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }


    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails paul = User.builder().username("paul").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(john,paul,susan);
    }*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
      http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
                      .requestMatchers("/leaders/**").hasRole("MANAGER")
                      .requestMatchers("/systems/**").hasRole("ADMIN")
                      .anyRequest().authenticated()).formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll())
              .logout(logout -> logout.permitAll())
              .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
