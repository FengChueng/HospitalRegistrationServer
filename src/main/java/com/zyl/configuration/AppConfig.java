package com.zyl.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	/**
	 * 静态资源映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
		// 指定外部文件
		// registry.addResourceHandler("/api_files/**").addResourceLocations("file:D:/data/api_files");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/file/operation").setViewName("/file");
		
		
		registry.addViewController("/docter/loginpage").setViewName("/doctorlogin");
		
		registry.addViewController("/patient/loginPage").setViewName("/login");
		
		registry.addViewController("/patient/registerpage").setViewName("/register");
		
		registry.addViewController("/hospital/index").setViewName("/hospital");
		
		registry.addViewController("/department/index").setViewName("/department");
		
		registry.addViewController("/appointment/index").setViewName("/appointment");
		
		registry.addViewController("/schedule/index").setViewName("/schedule");
	}

}
