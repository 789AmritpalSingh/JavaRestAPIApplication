package com.amrit.javarestapiwithspring_springboot_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.amrit.javarestapiwithspring_springboot_hibernate"})
@EntityScan(basePackages = {"com.amrit.javarestapiwithspring_springboot_hibernate.user"})
@EnableJpaRepositories(basePackages = {"com.amrit.javarestapiwithspring_springboot_hibernate.jpa"})
public class JavaRestApiWithSpringSpringBootHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRestApiWithSpringSpringBootHibernateApplication.class, args);
    }

}
