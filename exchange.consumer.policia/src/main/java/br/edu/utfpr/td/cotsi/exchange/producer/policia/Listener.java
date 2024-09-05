package br.edu.utfpr.td.cotsi.exchange.producer.policia;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@RabbitListener(queues = "federal.policia")
	public void listen(String in) {
		System.out.println("Polícia Federal");
		System.out.println("Processando transação: " + in);
	}
}