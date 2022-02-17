package com.thecontainerd.api.apidocumentos;

import com.thecontainerd.api.apidocumentos.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApidocumentosApplication implements CommandLineRunner {

	@Autowired
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(ApidocumentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}
