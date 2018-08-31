package com.rainpen.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author laiyup-S9644
 * @date 2018年05月31日
 */
@Configuration @EnableSwagger2 public class Swagger2 {

    /**
     * 通过Confiuration注解，让Spring加载改类配置，再通过EnableSwagger2来启动Swagger
     * 再通过createRestApi函数创建Docket的Bean之后，apiInfo()用来创建该API的基本信息（这些基本信息会展示在文档页面中）
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展示，本例采用扫描指定的包路径，
     * 扫描所有controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
     * @return
     */
    @Bean public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.rainpen.example.com.rainpen")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot使用swagger2构建RESTful APIs").description("此处添加描述")
                .termsOfServiceUrl("https://github.com/DONGZHANGXIWANG").contact("github超链").version("1.0").build();
    }

}
