package com.example.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

@EnableZuulProxy
@EnableConfigurationProperties({FilterConfiguration.class})
@Configuration
public class ZuulConfig {

	
	@Bean
	public FilterLoader filterLoader(FilterConfiguration filterConfiguration){
		FilterLoader filterLoader=FilterLoader.getInstance();
		filterLoader.setCompiler(new GroovyCompiler());
		try {
			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
			FilterFileManager.init(
					filterConfiguration.getInterval(),
					filterConfiguration.getRoot()+"/pre",
					filterConfiguration.getRoot()+"/post");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return filterLoader;
	}
}
