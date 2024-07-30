package com.biojj.helpregistration.config;

import com.biojj.helpregistration.service.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    private final DBService dbService;

    public TestConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @PostConstruct
    public void init() {
        dbService.InstanciaDB();
    }
}