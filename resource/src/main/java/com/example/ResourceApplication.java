package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.redis.connection.jedis.*;

@RestController
@SpringBootApplication
@EnableRedisHttpSession
public class ResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

/*
    @Bean
    HeaderHttpSessionStrategy sessionStrategy() {
      return new HeaderHttpSessionStrategy();
    }
    */

		@Bean
		public JedisConnectionFactory connectionFactory() {
			return new JedisConnectionFactory();
    }

		@RequestMapping("/resource")
		public Map<String, Object> home() {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("id", UUID.randomUUID().toString());
			model.put("content", "Hello Woooorrrld");
			return model;
		}
}
