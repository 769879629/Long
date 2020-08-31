package com.sy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.PostConstruct;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sy.mapper.es")
public class SpringEsConfig {

    /**
     * 解决和SpringDataRedis的冲突
     */
    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
