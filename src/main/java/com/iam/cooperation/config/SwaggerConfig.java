package com.iam.cooperation.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket configure(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .alternateTypeRules(
                        AlternateTypeRules.newRule(
                                typeResolver.resolve(Collection.class, WildcardType.class),
                                typeResolver.resolve(List.class, WildcardType.class))
                )
                .enableUrlTemplating(true)
                .forCodeGeneration(false);
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cooperation")  //标题
                .description("Cooperation API")  //描述
                .termsOfServiceUrl("https://github.com/self-free/cooperation")  //超链接
                .contact(new Contact("self-free","https://github.com/self-free/","x@mail.com"))   // 联系方式
                .version("1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .build();
    }

}
