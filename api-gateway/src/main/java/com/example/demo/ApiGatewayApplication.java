package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.AbstractServerHttpRequest;

import io.netty.handler.codec.http.HttpResponse;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Log4j2
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	public GlobalFilter postFilter() {
		return (exchange,chain) ->{
			return chain.filter(exchange)
					.then(Mono.fromRunnable(()->{
					log.info("Global Post filter executed");
					exchange.getResponse().getHeaders().add("Author", "bfl-byte");
//					AbstractServerHttpRequest resp = (AbstractServerHttpRequest)exchange.getResponse();
//					log.info(resp.getNativeRequest().toString());
					exchange.getResponse().setRawStatusCode(209);
					}));
		};
	}

}
