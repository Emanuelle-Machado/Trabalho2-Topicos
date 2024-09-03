package trabalho.utfpr.tsi.exchange.consumer.policia;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("trabalho.utfpr.tsi.exchange")
public class ExchangeConsumerApp {
	
	@Autowired
	private AmqpAdmin amqpAdmin;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExchangeConsumerApp.class, args);
	}
	
	@PostConstruct
	public void configurarCanais() {
		Queue fila1 = new Queue("federal.policia", true);
		amqpAdmin.declareQueue(fila1);
	}
}
