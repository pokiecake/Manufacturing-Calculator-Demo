package org.pokiecake.blueprintcalculator.security;

import org.pokiecake.blueprintcalculator.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // defines the bcrypt encoder as a bean
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // defines the DAO authentication provider as a bean
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) {
        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   AuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        http.authorizeHttpRequests(configurer ->
                                configurer
                                        .requestMatchers(HttpMethod.GET, "/home").hasRole("EMPLOYEE")
                                //!! Only for debugging purposes
//                        .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/api/**").permitAll()
//                        .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
//                .exceptionHandling(configurer ->
//                        configurer.accessDeniedPage("/access-denied")
//                );

        //TODO Remove when finished and figured out how to do csrf tokens
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
