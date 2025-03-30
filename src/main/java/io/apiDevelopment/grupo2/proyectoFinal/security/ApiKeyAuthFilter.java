package io.apiDevelopment.grupo2.proyectoFinal.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApiKeyAuthFilter extends OncePerRequestFilter{

	private final ApiKeyAuthCompany apiKeyCompany;
	private final ApiKeyAuthSensor apiKeySensor;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String endpoint = request.getRequestURL().toString().split("/")[5];
	
		if(endpoint.equals("location") || endpoint.equals("sensor") ||
		  (endpoint.equals("sensor_data") && request.getMethod().equals("GET"))) {			
			apiKeyCompany.extract(request)
			.ifPresent(SecurityContextHolder.getContext()::setAuthentication);
		}
		
		if(endpoint.equals("sensor_data") && request.getMethod().equals("POST")) {
			apiKeySensor.extract(request)
			.ifPresent(SecurityContextHolder.getContext()::setAuthentication);
		}
		
		filterChain.doFilter(request, response);
	}

	
	
}
