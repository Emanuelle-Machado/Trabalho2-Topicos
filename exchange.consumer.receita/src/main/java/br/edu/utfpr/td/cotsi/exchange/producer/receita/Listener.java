package br.edu.utfpr.td.cotsi.exchange.producer.receita;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@RabbitListener(queues = "federal.receita")
	public void listen(String in) {
		System.out.println("Receita Federal");
		System.out.println("Processando transação: " + in);
	}
}