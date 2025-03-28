package com.example.demo.system.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class AuditEventListener {

    //
    private static final Logger log = LoggerFactory.getLogger(AuditEventListener.class);

    /**
     *
     *
     * @param event
     */
    @Async
    @EventListener
    public void onAuditEvent(AuditApplicationEvent event) {
        AuditEvent auditEvent = event.getAuditEvent();
        log.warn(auditEvent.toString());
    }
}
