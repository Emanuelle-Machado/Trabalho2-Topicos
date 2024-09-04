package br.edu.utfpr.td.cotsi.exchange.producer.policia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.federal.policia")
public class ExchangeConsumerApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeConsumerApp.class, args);
	}

}