package com.xipengyuan.demo.jpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

    private Environment environment;

    @Value("${jdbc.connection.timeout}")
    private long connectionTimeout;

    @Value("${jdbc.minimum.idle}")
    private int minIdle;

    @Value("${jdbc.maximum.pool.size}")
    private int maxPoolSize;

    @Value("${jdbc.idle.timeout}")
    private long idleTimeout;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getProperty("jdbc.driver.class.name"));
        config.setJdbcUrl(environment.getProperty("jdbc.url"));
        config.setUsername(environment.getProperty("jdbc.username"));
        config.setPassword(environment.getProperty("jdbc.password"));
        config.setConnectionTimeout(connectionTimeout);
        config.setMinimumIdle(minIdle);
        config.setMaximumPoolSize(maxPoolSize);
        config.setIdleTimeout(idleTimeout);
        return new HikariDataSource(config);
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
