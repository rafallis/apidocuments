package com.thecontainerd.api.apidocuments;

import com.thecontainerd.api.apidocuments.service.LocalStorageService;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ApidocumentosApplication implements CommandLineRunner {

	@Autowired
	LocalStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(ApidocumentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}
