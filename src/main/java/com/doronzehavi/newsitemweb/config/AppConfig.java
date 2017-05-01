package com.doronzehavi.newsitemweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@PropertySource("app.properties")
@EnableJpaRepositories("com.doronzehavi.newsitemweb.dao")
public class AppConfig {
    @Autowired
    private Environment env;



}
