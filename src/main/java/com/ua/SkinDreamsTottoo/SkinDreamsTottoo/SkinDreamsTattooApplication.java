package com.ua.SkinDreamsTottoo.SkinDreamsTottoo;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.ClientValidator;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.ReviewValidator;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.TravelingMasterValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;


@SpringBootApplication
public class SkinDreamsTattooApplication {

	@Value("${spring.mail.host}")
	private String mailHost;
	@Value("${spring.mail.port}")
	private int mailPort;
	@Value("${spring.mail.username}")
	private String mailUsername;
	@Value("${spring.mail.password}")
	private String mailPassword;


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

	@Bean
	ReviewValidator reviewValidator(){
		return new ReviewValidator();
	}

	@Bean
	TravelingMasterValidator travelingMasterValidator(){
		return new TravelingMasterValidator();
	}

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailHost);
		mailSender.setPort(mailPort);
		mailSender.setUsername(mailUsername);
		mailSender.setPassword(mailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}
