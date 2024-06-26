package com.appsdeveloperblog.photoapp.api.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoAppAccountManagemnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppAccountManagemnetApplication.class, args);
	}

}
