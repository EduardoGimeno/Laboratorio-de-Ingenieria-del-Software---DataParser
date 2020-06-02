package com.DP.DataParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.DP.DataParser.Servicio.Parser;

@SpringBootApplication
public class DataParserApplication {

	@Autowired
	Parser p;

	@Bean
	public void traducir() {
		p.crearEspacios();
	}

	public static void main(String[] args) {
		SpringApplication.run(DataParserApplication.class, args);
	}

}
