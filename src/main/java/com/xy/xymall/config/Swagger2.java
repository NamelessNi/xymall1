package com.xy.xymall.config;
/**
 * Swagger2 配置类
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@ComponentScan("com.xy.xymall.controllor")
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xy.xymall.controllor"))
                .paths(PathSelectors.any())
                .build();
    }
/* 通过createRestApi函数创建Docket的Bean之后，
apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
这里采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
并产生文档内容（除了被@ApiIgnore指定的请求）。*/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商城RESTful APIs")
                .description("原文地址链接：http://blog.didispace.com/springbootswagger2/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("@xy")
                .version("1.0")
                .build();
    }
}
