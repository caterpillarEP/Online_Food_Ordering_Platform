package com.food.config;

	import org.springframework.context.annotation.Bean;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.web.SecurityFilterChain;
	import org.springframework.context.annotation.Configuration;

	@Configuration
	public class SecurityConfig {
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(csrf -> csrf.disable())  // Disable CSRF for testing (Enable in production)
	            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
	        return http.build();
	    }
	
}
