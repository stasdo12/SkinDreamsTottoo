package com.ua.SkinDreamsTottoo.SkinDreamsTottoo;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.EmailSenderService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.ClientValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class SkinDreamsTattooApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SkinDreamsTattooApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Bean
	public ClientValidator clientValidator() {
		return new ClientValidator();
	}

}
