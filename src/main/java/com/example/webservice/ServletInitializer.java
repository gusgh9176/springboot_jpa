//package com.example.webservice;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//// war 파일 생성
//
//@EnableJpaAuditing // JPA Auditing 활성화
//@SpringBootApplication
//public class ServletInitializer extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(ServletInitializer.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ServletInitializer.class, args);
//    }
//
//}