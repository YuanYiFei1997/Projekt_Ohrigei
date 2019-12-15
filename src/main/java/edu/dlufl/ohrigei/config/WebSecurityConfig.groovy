package edu.dlufl.ohrigei.config

import edu.dlufl.ohrigei.service.userService.Impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder
    private final String KEY="ohrigei"
    @Bean
    UserDetailsService customUserService() {
        return new UserServiceImpl()
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserService());
        authenticationProvider.setPasswordEncoder(passwordEncoder); // 设置密码加密方式
        authenticationProvider.hideUserNotFoundExceptions = false
        return authenticationProvider;
    }

    void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/js/**", "/fonts/**", "/img/**", "/css/**", "/allUser/**","/error/**")
    }

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
        httpSecurity.formLogin().loginPage("/login").usernameParameter("email")
                .successForwardUrl("/index").failureUrl("/login?error=true")
                .and().exceptionHandling().accessDeniedPage("/error/403")
        httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
        httpSecurity.rememberMe().key(KEY).tokenValiditySeconds(3600)
    }

    void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService())
        auth.authenticationProvider()
    }
}
