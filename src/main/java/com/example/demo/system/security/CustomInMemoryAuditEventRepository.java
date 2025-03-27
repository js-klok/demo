package com.example.demo.system.security;

import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class CustomInMemoryAuditEventRepository extends InMemoryAuditEventRepository {
}
