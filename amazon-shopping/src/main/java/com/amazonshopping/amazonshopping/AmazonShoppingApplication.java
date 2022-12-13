package com.amazonshopping.amazonshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AmazonShoppingApplication {

// A load balanced RestTemplate can be configured to
// retry failed requests. By default this logic is disabled,
// you can enable it by adding Spring Retry to your
// application's classpath. The load balanced RestTemplate
// will honor some of the Ribbon configuration values
// related to retrying failed requests.
// multiple resources can access our microservice
// so better to annotate with @LoadBalanced


// Load balancing is the process of distributing
// traffic among different instances of the same
// application. To create a fault-tolerant system,
// it's common to run multiple instances of each
// application. Thus, whenever one service needs to
// communicate with another, it needs to pick a
// particular instance to send its request.

	@LoadBalanced
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AmazonShoppingApplication.class, args);
	}
}
