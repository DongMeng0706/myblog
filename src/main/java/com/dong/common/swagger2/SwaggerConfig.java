package com.dong.common.swagger2;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket2(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户端")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dong.home"))
                .paths(PathSelectors.any())
                .build();
        return docket;

    }
    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理员端")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dong"))
                .paths(PathSelectors.any())
                .build();
        return docket;

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                        .title("DM dong")
                        .description("生命不息 学习不止")
                        .version("v1.0")
                        .contact(new Contact("DM","http://www.dangyonghang.com","496056171@qq.com"))
                        .license("Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build();


    }
}
