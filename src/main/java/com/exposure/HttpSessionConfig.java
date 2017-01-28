package com.exposure;

import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

//@Configuration
//@EnableRedisHttpSession 
public class HttpSessionConfig {

/*        @Bean
        public JedisConnectionFactory connectionFactory() {
        	JedisConnectionFactory jedis =  new JedisConnectionFactory(); 
        	jedis.setHostName("10.68.51.99");
        	jedis.setPort(6379);
        	return jedis;
        }*/

        @Bean
        public HttpSessionStrategy httpSessionStrategy() {
                return new HeaderHttpSessionStrategy(); 
                
        }
}
