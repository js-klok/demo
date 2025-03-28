package com.example.demo.system.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 */
public class CustomServerAccessDeniedHandler implements ServerAccessDeniedHandler {

    //
    private static final Logger log = LoggerFactory.getLogger(CustomServerAccessDeniedHandler.class);

    /**
     *
     * @param exchange
     * @param ex
     * @return
     */
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException ex) {
        log.warn("CustomServerAccessDeniedHandler: {}", ex.getMessage());
        return exchange.getResponse().setComplete();
    }
}
