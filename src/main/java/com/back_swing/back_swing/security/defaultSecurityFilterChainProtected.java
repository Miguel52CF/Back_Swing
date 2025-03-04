package com.back_swing.back_swing.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class defaultSecurityFilterChainProtected {

  @Value("${role_teacher}")
  private String TEACHER_ROLE;

  @Value("${role_student}")
  private String STUDENT_ROLE;

  @Value("${role_admin}")
  private String ADMIN_ROLE;

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http
        .cors(cors -> cors.disable())
        .csrf(csrf -> csrf.disable())
        .authorizeExchange(auth -> auth
            .pathMatchers("/").permitAll()
            .pathMatchers("/api/**").hasAnyRole(TEACHER_ROLE, STUDENT_ROLE, ADMIN_ROLE)
            .pathMatchers("/admin/**").hasRole(ADMIN_ROLE)
            .anyExchange().permitAll())
        .formLogin(ServerHttpSecurity.FormLoginSpec::disable) // ❌ permitAll() no existe, se elimina
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutHandler(new SecurityContextServerLogoutHandler()) // Cierra la sesión
            .logoutHandler(new WebSessionServerLogoutHandler()) // Invalida la sesión WebFlux
            .logoutSuccessHandler((exchange, authentication) -> Mono.empty()));

    return http.build();
  }
}
