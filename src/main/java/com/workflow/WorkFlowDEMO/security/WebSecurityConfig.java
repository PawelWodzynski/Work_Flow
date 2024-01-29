package com.workflow.WorkFlowDEMO.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {

    /**
     * Configuration for JDBC-based user details management.
     *
     * This method defines a bean for UserDetailsManager that utilizes JDBC for user details storage.
     * The queries are specified to retrieve user information and authorities (roles) by username.
     * Users' authorization is made possible as the script retrieves usernames along with their roles.
     *
     * @param dataSource The DataSource used for JDBC operations.
     * @return UserDetailsManager bean configured with JDBC for user details management.
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // Create a new instance of JdbcUserDetailsManager using the provided DataSource
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Query to retrieve user details by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, 1 as enabled from employee where username=?"
        );

        // Query to retrieve user authorities (roles) by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select u.username, r.name from employee_roles ur " +
                        "join employee u on ur.user_id = u.id " +
                        "join role r on ur.role_id = r.id " +
                        "where u.username=?"
        );

        // Return the configured JdbcUserDetailsManager bean
        return jdbcUserDetailsManager;
    }




    /**
     * Bean definition for the password encoder.
     *
     * @return BCryptPasswordEncoder bean for encoding passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    /**
     * Bean definition for the AuthenticationManager.
     *
     * @param userDetailsService UserDetailsService bean for retrieving user details.
     * @param encoder PasswordEncoder bean for encoding passwords.
     * @return AuthenticationManager bean configured with a DaoAuthenticationProvider.
     * @throws Exception Throws an exception in case of configuration error.
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(encoder);
        return new ProviderManager(provider);
    }





    /**
     * Security configuration for Spring Security.
     *
     * This method defines security rules for different paths in the application.
     * Users must have specific roles to access certain resources.
     * In case of unauthorized access, a login page is displayed.
     * After successful authentication, the user has access to all other resources.
     * Additionally, the configuration includes a custom login page, logout handling,
     * and exception handling, including access denied redirected to the /access-denied page.
     *
     * @param httpSecurity Configuration object for HttpSecurity, responsible for security configuration.
     * @return SecurityFilterChain object representing the security filter chain for the application.
     * @throws Exception Throws an exception in case of configuration error.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        // Authorization configuration for different paths
        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/workFlow/appCenter").hasRole("EMPLOYEE") // For the main page, the "EMPLOYEE" role is required
                                .requestMatchers("/employees/**").hasRole("ADMIN") // For the Employees Pages "ADMIN" role is required, Employees pages is used for employee managment
                                .anyRequest().authenticated() // For other paths, general authentication is required
                )
                // Login form configuration
                .formLogin(form ->
                        form.loginPage("/loginPage") // Specifies a custom login page
                                .loginProcessingUrl("/authenticateTheUser") // Specifies the path for processing authentication request
                                .permitAll() // Allows access to the login page for all users
                )
                // Logout handling configuration
                .logout(logout ->
                        logout.permitAll() // Allows access to the logout page for all users
                )
                // Exception handling configuration
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied") // Specifies the page for access denied
                );

        // Returns the configured SecurityFilterChain object
        return httpSecurity.build();
    }
}
