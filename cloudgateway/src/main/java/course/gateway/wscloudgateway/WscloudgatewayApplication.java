package course.gateway.wscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class WscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WscloudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){

     return builder
			 .routes()
			 	.route( r -> r.path("/clientes/**").uri("lb://ws-clientes") )
			 	.route( r -> r.path("/popular/**").uri("lb://ws-clientessss") )
			 	.route( r -> r.path("/cartoes/**").uri("lb://wscartoes") )
			 	.route( r -> r.path("/avaliacoes-credito/**").uri("lb://ws-avaliadorcredito") )
			 .build();
	}
}
