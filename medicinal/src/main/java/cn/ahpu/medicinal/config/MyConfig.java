package cn.ahpu.medicinal.config;

import cn.ahpu.medicinal.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyConfig  implements WebMvcConfigurer {

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    /*使得静态文件放行*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/ahpu").setViewName("page/login");
        registry.addViewController("/medicinal/success").setViewName("page/index");
    }

    /* 配置Bean的Config，不会覆盖原来的配置 */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer wmv = new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/ahpu").setViewName("page/login");
                registry.addViewController("/user/ahpu").setViewName("page/ahpu");
            }

            /* 配置静态资源不拦截 */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {

            }
            /* 配置拦截器 */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                        .excludePathPatterns("/ahpu", "/user/tologin","static/**","/user/login","/user/tochangepwd");
            }


        };
        return wmv;
    }

}
