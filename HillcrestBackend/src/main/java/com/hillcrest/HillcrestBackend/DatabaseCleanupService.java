package com.hillcrest.HillcrestBackend;

import jakarta.annotation.PreDestroy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCleanupService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseCleanupService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PreDestroy
    public void cleanup() {
        try {
            // Execute cleanup on shutdown only
            jdbcTemplate.execute("DROP SCHEMA public CASCADE");
            jdbcTemplate.execute("CREATE SCHEMA public");
            jdbcTemplate.execute("GRANT ALL ON SCHEMA public TO postgres");
            jdbcTemplate.execute("GRANT ALL ON SCHEMA public TO public");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}