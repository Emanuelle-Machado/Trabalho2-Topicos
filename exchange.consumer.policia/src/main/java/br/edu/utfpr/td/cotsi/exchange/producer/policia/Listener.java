package trabalho.utfpr.tsi.exchange.consumer.policia;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
    
	@RabbitListener(queues = "transacoes.financeiras")
    public void processarEvento(Map<String, Object> evento) throws InterruptedException {
        double valor = (double) evento.get("valor");
        System.out.println("Processando transação: " + evento);
        Thread.sleep(1000);

        if (valor >= 40000) {
            notificarAutoridades(evento);
        }
    }

    private void notificarAutoridades(Map<String, Object> evento) {
        // Enviar eventos para o Exchange fanout
    	rabbitTemplate.convertAndSend("fanout.ex", "", evento);

        System.out.println("Notificação enviada para as autoridades: " + evento);
    }
}
