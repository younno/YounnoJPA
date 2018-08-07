package com.lyn.study.springboot.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration	
public class EncodingFilter {
	
	/*CharacterEncodingFilter로 하면 안되고, Filter로 하니까 깨지지 않고 잘 됨
		출처: http://countryxide.tistory.com/10 [배워서 남주자]
	 */
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public Filter  characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
	
}
