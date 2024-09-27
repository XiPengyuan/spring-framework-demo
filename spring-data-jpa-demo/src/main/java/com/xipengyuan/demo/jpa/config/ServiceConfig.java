package com.xipengyuan.demo.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.xipengyuan.demo.jpa.service")
@Import(PersistenceConfig.class)
public class ServiceConfig {
}
