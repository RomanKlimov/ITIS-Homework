package ru.kpfu.springwebmvc.config;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Roman on 24.02.2018.
 */

@Configuration
public class DBConfig {
    @Autowired
    private Environment environment;

    @Bean(name = "JDBC")
    @Profile("live")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(this.environment.getProperty("db.driver"));
        dataSource.setUrl(this.environment.getProperty("db.url"));
        dataSource.setUsername(this.environment.getProperty("db.username"));
        dataSource.setPassword(this.environment.getProperty("db.password"));

        return dataSource;

    }
    }



