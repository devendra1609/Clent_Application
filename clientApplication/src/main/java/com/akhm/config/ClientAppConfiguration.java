package com.akhm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientAppConfiguration {
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
