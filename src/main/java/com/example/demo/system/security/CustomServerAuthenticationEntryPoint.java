package com.example.demo.system.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CustomServerAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    //
    private static final Logger log = LoggerFactory.getLogger(CustomServerAuthenticationEntryPoint.class);

    /**
     *
     * @param exchange
     * @param ex
     * @return
     */
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException ex) {
        log.warn(ex.getMessage());
        return Mono.empty();
    }
}
