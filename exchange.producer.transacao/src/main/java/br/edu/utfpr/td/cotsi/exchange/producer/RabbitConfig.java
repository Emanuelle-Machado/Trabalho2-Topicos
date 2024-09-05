package br.edu.utfpr.td.cotsi.exchange.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	@Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("transacoes.suspeitas");
    }

    @Bean
    Queue filaPoliciaFederal() {
        return new Queue("federal.policia");
    }

    @Bean
    Queue filaReceitaFederal() {
        return new Queue("federal.receita");
    }

    @Bean
    Binding bindingPolicia(FanoutExchange fanoutExchange, Queue filaPoliciaFederal) {
        return BindingBuilder.bind(filaPoliciaFederal).to(fanoutExchange);
    }

    @Bean
    Binding bindingReceita(FanoutExchange fanoutExchange, Queue filaReceitaFederal) {
        return BindingBuilder.bind(filaReceitaFederal).to(fanoutExchange);
    }
	
	

}
