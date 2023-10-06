package com.douzone.comet.service.hr.dwagger.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.douzone.comet.service.hr.dwagger.models.CacheDwaggerModels;

@Configuration
@ComponentScan(basePackages = "com.douzone.comet.service.hr.dwagger")
public class BeanConfig {
	@Bean
	public CacheDwaggerModels cacheDwaggerModels() {
		return new CacheDwaggerModels();
	}
	@Bean
	public JsonUtils jsonUtils() {
		return new JsonUtils();
	}

}
