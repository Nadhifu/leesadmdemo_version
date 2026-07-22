package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
//import com.vaadin.flow.component.dependency.Stylesheets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
//@StyleSheet("styles.css")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
