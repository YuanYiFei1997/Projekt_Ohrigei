package edu.dlufl.ohrigei.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**")hasRole("USER")
        httpSecurity.formLogin().loginPage("/").permitAll().and().csrf().disable()
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll()
    }
}
