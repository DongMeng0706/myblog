package com.dong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@EnableCaching()
@EnableTransactionManagement(proxyTargetClass = true)//开启cglib
@MapperScan("com.dong.*.mapper")
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.dong.test.*")
})
@SpringBootApplication()
public class DongApplication extends SpringBootServletInitializer{

    public static void main (String[] args) {
        SpringApplication.run(DongApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DongApplication.class);
    }
}
