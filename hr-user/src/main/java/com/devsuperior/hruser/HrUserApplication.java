package com.devsuperior.hruser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HrUserApplication implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(HrUserApplication.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SUCESSO :> | Chave BCRYPT = " + passwordEncoder.encode("Estuda que muda"));
		//logger.info("SUCESSO :> | Chave BCRYPT = " + passwordEncoder.encode("Estuda que muda"));
	}

}
