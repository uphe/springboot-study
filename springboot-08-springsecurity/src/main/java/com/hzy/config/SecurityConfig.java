package com.hzy.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 认证
    // 密码编码 BCryptPasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据应该从数据库中读取
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()) // 设置密码加密
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3")
                .and()
                .withUser("hzy").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");

    }

    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/*").hasRole("vip1")
                .antMatchers("/level2/*").hasRole("vip2")
                .antMatchers("/level3/*").hasRole("vip3");

        // 没有权限会默认到登录页面，定制登录页
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/toLogin");

        // 开启注销功能，跳到首页
        http.logout().logoutSuccessUrl("/");
        // 开启记住我功能，自定义接受前端参数
        http.rememberMe().rememberMeParameter("remember");

    }
}
