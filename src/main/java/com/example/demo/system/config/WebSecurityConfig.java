package com.example.demo.system.config;

import com.example.demo.system.security.CustomServerAccessDeniedHandler;
import com.example.demo.system.security.CustomServerAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 *
 */
@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

    /**
     *
     * @param http
     * @return
     */
    @Bean
    SecurityWebFilterChain apiSecurityFilter(ServerHttpSecurity http) {
        return http
            .authorizeExchange(auth -> auth
                .anyExchange().authenticated())
            .httpBasic(Customizer.withDefaults())
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .exceptionHandling(spec -> {
                spec.authenticationEntryPoint(new CustomServerAuthenticationEntryPoint());
                spec.accessDeniedHandler(new CustomServerAccessDeniedHandler()); // <--- not being triggered
            })
            .build();
    }

}