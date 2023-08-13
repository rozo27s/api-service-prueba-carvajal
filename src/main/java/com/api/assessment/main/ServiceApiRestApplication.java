package com.api.assessment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.api.assessment",
                                            "com.api.assessment.module" })
@EnableJpaRepositories(basePackages = { "com.api.assessment.framework.jpa.crudrepository" })
@EntityScan(basePackages = { "com.api.assessment.framework.jpa.entity" })
public class ServiceApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApiRestApplication.class, args);
    }

}
