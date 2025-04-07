package io.apiDevelopment.grupo2.proyectoFinal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final ApiKeyAuthFilter authFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(httpRequest -> {
				httpRequest.requestMatchers(HttpMethod.POST, "/api/v1/company/").permitAll();
				httpRequest.requestMatchers("/api/**").authenticated();
			})
			.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
