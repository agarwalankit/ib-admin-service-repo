package org.bluemount.adminservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring Boot App class.
 * Initiates the App.
 */
@SpringBootApplication
public class AdminServiceApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminServiceApp.class);
    }

    /**
     * Intiatlizer Method
     * @param args arguments for app initialization.
     */
    public static void main(String[] args){
        SpringApplication.run(AdminServiceApp.class, args);
        Logger logger = LoggerFactory.getLogger(AdminServiceApp.class);
        logger.info("---AdminServiceApp App Initialized----");
    }
}
