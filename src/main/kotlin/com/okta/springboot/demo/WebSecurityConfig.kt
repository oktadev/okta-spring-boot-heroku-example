package com.okta.springboot.demo

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity): Unit = with(http) {
        authorizeRequests().run {
            antMatchers("/").permitAll()
            anyRequest().authenticated()
        }
        oauth2Login().run {
            defaultSuccessUrl("/")
        }
        logout().run {
            logoutSuccessUrl("/")
        }
    }
}
