package br.edu.utfpr.td.cotsi.exchange.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class Listener {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;

	@RabbitListener(queues = "transacoes.financeiras")
	public void listen(String in) {
		processarTransacao(in);
		System.out.println("ouvindo transacao" + in);
	}
	
	public void processarTransacao(String in) {
		try {			
			System.out.println("Processando transacao");
			Thread.sleep(1000);

			Transacao transacao = new Gson().fromJson(in, Transacao.class);
			
			if (transacao.getValor() > 40000) {
				rabbitTemplate.convertAndSend("transacoes.suspeitas", "", in);
				System.out.println("valor > 40000" + in);
			}else {
				System.out.println(in);
			}
		
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			System.out.println("catch exceção");
		}
	}
}