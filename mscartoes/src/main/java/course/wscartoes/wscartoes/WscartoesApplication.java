package course.wscartoes.wscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WscartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WscartoesApplication.class, args);
	}

}
