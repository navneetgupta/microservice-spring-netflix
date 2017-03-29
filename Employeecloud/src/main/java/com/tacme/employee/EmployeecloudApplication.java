package com.tacme.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration
@ComponentScan("com.tacme")
@EntityScan("com.tacme")
@EnableJpaRepositories(basePackages="com.tacme")
@PropertySources({
	@PropertySource("file:/opt/proserv/properties/employee.properties")
})
@EnableEurekaClient
public class EmployeecloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeecloudApplication.class, args);
	}
}
