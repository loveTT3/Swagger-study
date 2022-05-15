package com.yang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    /**
     *RequestHandlerSelectors 配置要扫描的接口方式
     * .basePackage() 指定要扫描的包
     * any() 扫描全部
     * none() 全部不扫描
     * withClassAnnotation 扫描类上的注解，参数是一个注解的反射对象
     * withMethodAnnotation 扫描方法上的注解
     */
    /**
     * paths
     *客户端访问路径过滤
     */
    // 配置了swagger的Docket的been实例
    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev");

        // 获取项目环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("杨佳龙")
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.yang.swagger.controller"))
//                .paths(PathSelectors.ant("/heello")) // 路径里面
                .build();
    }


    // 配置sqagger信息 = apiinfo
    public ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("杨佳龙", "http://www.baidu.com", "http://www.baidu.com");
        Contact contact1 = new Contact("", "", "");

        return new ApiInfo(
//                "我的第一个swagger程序",
//                "这里写的是描述",
//                "v1.0",
//                "http://www.baidu.com",
//                contact,
//                "Apache 2.0呢",
//                "http://www.apache.org/licenses/LICENSE-2.0",

                "我的第一个swagger程序",
                "",
                "",
                "",
                contact1,
                "",
                "",
                new ArrayList());

    }
//    @Bean
//    public Docket docket1(Environment environment){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//    @Bean
//    public Docket docket2(Environment environment){
//        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }
}
