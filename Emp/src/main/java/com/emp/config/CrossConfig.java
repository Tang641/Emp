package com.emp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")  //允许跨域的请求
                 .allowedOriginPatterns("*")  //允许的域名
                 .allowCredentials(true) //是否允许通知
                 .allowedMethods("GET","POST","DELETE","PUT","OPTIONS")
                 .allowedHeaders("*")
                 .maxAge(3600); //允许跨域的时间
    }
}
