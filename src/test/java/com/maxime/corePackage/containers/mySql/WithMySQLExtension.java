package com.maxime.corePackage.containers.mySql;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootApplication(scanBasePackages = {"com.maxime.corePackage"})
@ComponentScan(basePackages = "com.maxime.corePackage.repositories.student")
public class WithMySQLExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    private static final Logger LOG = LoggerFactory.getLogger(WithMySQLExtension.class);
    @Container
    public static MySQLContainer<?> MYSQL_CONTAINER = new MySQLContainer<>("mysql:5.7.37-oracle");
    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            MYSQL_CONTAINER.start();
            System.setProperty("spring.jpa.enabled", "true");
            // System.setProperty("spring.jpa.show_sql", "true");
            System.setProperty("spring.datasource.driverClassName", MYSQL_CONTAINER.getDriverClassName());
            System.setProperty("spring.datasource.url", MYSQL_CONTAINER.getJdbcUrl());
            System.setProperty("spring.datasource.username", MYSQL_CONTAINER.getUsername());
            System.setProperty("spring.datasource.password", MYSQL_CONTAINER.getPassword());
            LOG.info("MYSQL PORT {}", MYSQL_CONTAINER.getMappedPort(3306));

        }
    }

    @Override
    public void close() {
        MYSQL_CONTAINER.stop();
    }
}