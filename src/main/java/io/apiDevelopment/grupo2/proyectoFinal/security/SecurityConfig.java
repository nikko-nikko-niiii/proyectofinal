package io.apiDevelopment.grupo2.proyectoFinal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public ApiKeyAuthFilter authFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		
		
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(httpRequest -> {
				/*httpRequest.requestMatchers(HttpMethod.POST, "/api/v1/admin/login").permitAll();
				httpRequest.requestMatchers(HttpMethod.POST, "/api/v1/company/").hasRole("ADMIN");
				httpRequest.requestMatchers(HttpMethod.POST, "/api/v1/location/").hasRole("ADMIN");
				httpRequest.requestMatchers(HttpMethod.POST, "/api/v1/sensor/").hasRole("ADMIN"); */
				httpRequest.requestMatchers("/api/**").authenticated();
				httpRequest.anyRequest().permitAll();
			})
			.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}

}
