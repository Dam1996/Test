package com.misionarg.Seguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Base64;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class SeguridadApplication {

	public static void main(String[] args) {

		SpringApplication.run(SeguridadApplication.class, args);

	}

}
