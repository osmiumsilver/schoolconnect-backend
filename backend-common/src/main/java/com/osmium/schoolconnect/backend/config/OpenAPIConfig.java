package com.osmium.schoolconnect.backend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;

/**
 * @Author
 * @Date 2023/1/13
 * @Description
 */
@Configuration

public class OpenAPIConfig {

    //配置了Swagger的Docker的Bean实例
    @Bean
    public GroupedOpenApi docket(){
        return GroupedOpenApi.builder()
                .group("schoolconnect")
                .pathsToMatch("/**")
  //              .apiInfo(apiInfo())
  //              .enable(true) //配置是否启用Swagger，如果是false，在浏览器将无法访问
   //             .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
 //               .apis(RequestHandlerSelectors.basePackage("com.osmium.schoolconnect.backend.controller"))
                .build();
    }

    //配置swagger信息 apiInfo
 /*   private ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("abel", "https://www.osmium.com", "osmium@hotmail.com");

        return new ApiInfo(
                "api文档",
                "api描述信息",
                "v1.0",
                "http://localhost:8082",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());

    }*/
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SchoolConnect Backend API")
                        .description("校园服务台后端 API 说明")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("校园服务台 官方网站")
                        .url("https://schoolconnect.abelyao.cn/"));
    }
}
