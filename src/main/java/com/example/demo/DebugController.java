package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class DebugController {

    /**
     *
     * @return
     */
    @GetMapping(value = "/debug", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> debug() {
        return Mono.just(UUID.randomUUID().toString());
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/error", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> error() {
        throw new RuntimeException("error");
    }


}
