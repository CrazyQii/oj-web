package org.example.oj.config;

import org.example.oj.common.RoleEnum;
import org.example.oj.common.URIConst;
import org.example.oj.config.filter.ValidateCodeFilter;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 权限配置管理
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Resource
    private DataSource dataSource;

    @Resource
    private UserDetailsService userDetailsService;


    @Resource
    private AuthenticationFailureHandler loginFailureHandler;

    @Resource
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncode() {
        return new BCryptPasswordEncoder();
    }


    /**
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncode());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new ValidateCodeFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/user/loginPage")
                .loginProcessingUrl("/user/loginProcess")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessUrl("/")
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600 * 24)
                .userDetailsService(userDetailsService)
                .and()
                .sessionManagement()
                //记录session失效的一些行为
//                .invalidSessionUrl()
                //一个用户只有一个Session
                .maximumSessions(1)
                //当网站有一个用户的Session登录了，当达到最大数量后，别的不允许登录
//                .maxSessionsPreventsLogin(true)
                //记录谁的登录导致session被替换，失效了
//                .expiredSessionStrategy()
                .and()
                .and()
                .authorizeRequests()
                .antMatchers(URIConst.ALLOWED_URI).permitAll()
                .antMatchers(URIConst.NOT_ALLOWED_URI)
                .hasRole(RoleEnum.ADMIN.getConfigName())
                .anyRequest()
                .permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable();

    }

}
