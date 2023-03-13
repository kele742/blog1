package com.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//重写一个关于web过滤器的设置
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //过滤哪些路径，此时过滤所有admin路径下的
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin","/admin/login","/css/**","/image/**","/js/**","/lib/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
