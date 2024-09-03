package trabalho.utfpr.tsi.exchange.consumer.receita;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	

	@RabbitListener(queues = "transacoes.financeiras")
    public void processarEvento(Map<String, Object> evento) throws InterruptedException {

        System.out.println("Processando transação: " + evento);
        Thread.sleep(1000);
    }

}
