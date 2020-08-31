package com.sy;

import com.sy.config.CasConfig;
import com.sy.config.SpringEsConfig;
import com.sy.config.SpringShiroConfig1;
import com.sy.interceptor.InterceptorRules;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.sy")
//扫描mapper接口(使用TkMapper组件)
@MapperScan(value = "com.sy.mapper")
//容器启动优先级(可以不加)
@Order(Ordered.HIGHEST_PRECEDENCE)
//开启注解事务(可以不加)
@EnableTransactionManagement
//引入子配置项
@Import(value = {SpringShiroConfig1.class, SpringEsConfig.class,InterceptorRules.class, CasConfig.class})
//扫描ES包
@EnableElasticsearchRepositories(basePackages="com.sy.mapper.es")
public class SyAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyAgentApplication.class, args);
    }

}
