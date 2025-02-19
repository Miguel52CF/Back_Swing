package com.back_swing.back_swing.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class defaultSecurityFilterChainProtected {

  @Value("${role_teacher}")
  private String TEACHER_ROLE;

  @Value("${role_student}")
  private String STUDENT_ROLE;

  @Value("${role_admin}")
  private String ADMIN_ROLE;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/api/**")).hasAnyRole(TEACHER_ROLE, STUDENT_ROLE, ADMIN_ROLE)
            .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole(ADMIN_ROLE)
            .anyRequest().permitAll())
        .formLogin(form -> form
            .loginPage("/login")
            .usernameParameter("email")
            .permitAll())
        .logout(logout -> logout // Esto ya no estará tachado
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll());

    return http.build();
  }

}
