package com.meilun.config;

import com.meilun.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/images/**","/lib/**"
                        ,"/","/user/**","/{pageid}","/index/tags/{pageId}","/tags","/blog/detail/*",
                        "/blog/searchByTagsId/**")
        ;
    }
}
