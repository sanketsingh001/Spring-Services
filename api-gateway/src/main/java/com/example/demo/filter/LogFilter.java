package com.example.demo.filter;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class LogFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		URI uri =exchange.getRequest().getURI();
		log.info(uri.getRawPath()+"called at"+ LocalDateTime.now());
		return chain.filter(exchange);
	}

}
