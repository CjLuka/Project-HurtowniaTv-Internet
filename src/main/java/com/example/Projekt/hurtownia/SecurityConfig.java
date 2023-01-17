package com.example.Projekt.hurtownia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
    public InMemoryUserDetailsManager get(){
        UserDetails admin = User.withUsername("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();
        UserDetails gosc = User.withUsername("gosc")
            .password("{noop}gosc")
            .roles("GOSC")
            .build();
            return new InMemoryUserDetailsManager(admin, gosc);

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
            .antMatchers("/h2/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            .antMatchers("/logowanie/zalogujsie").hasAnyRole("ADMIN","GOSC")
           
            .and()
            .formLogin()
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/index")
                .permitAll()
            .and()
            .httpBasic();

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/h2/**");
    }
}
