package ru.ttv.meteringvaluesregistrationservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.ttv.meteringvaluesregistrationservice.service.UserService;

/**
 * Configuration WebSecurity
 * @author Teplykh Timofey  10.03.2019
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/config",
                        "/actuator/*",
                        "/actuator/**",
                        "/webjars/**").permitAll()
//                .antMatchers(
//                        "/registration**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();

//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/adv/*/edit").hasAuthority("admin")
//                .antMatchers(HttpMethod.GET,"/adv/add").hasAnyAuthority("admin","user")
//                .and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//                .usernameParameter("login").passwordParameter("password").failureUrl("/loginfailed")
//                .and().logout().logoutSuccessUrl("/");
//        http
//                .authorizeRequests()
//                .antMatchers("/*").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/login")
//                .loginPage("/login")
//                //.failureUrl("/security/loginfail")
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/logout");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
