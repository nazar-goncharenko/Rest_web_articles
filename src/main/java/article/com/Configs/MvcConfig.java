package article.com.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("**/bg/**").addResourceLocations("C:\\Users\\Nazar\\Documents\\GitHub\\Library\\Rest_web_articles\\src\\main\\resources\\views\\");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry
                .addViewController("/ind").setViewName("index");
        registry
                .addViewController("/login").setViewName("login");
        registry
                .addViewController("/profile").setViewName("profile");
        registry
                .addViewController("/tmp").setViewName("tmp");
    }
}
