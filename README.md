# Trabalho2-Topicos

trabalho para a matéria de tópicos avançados, para ser avaliado. 

#### Projeto RabbitMQ - Consumer e Producer com CSV

## Responsabilidades de cada Aplicação

- Produtor com leitor de CSV
    exchange.producer.lerCSV

- Faz o exchange de transacoes.suspeitas com as filas policia.federal e receita.federal
    exchange.producer.transacao

- Leitor da fila federal.policia
    exchange.consumer.policia

- Leitor da fila federal.receita
    exchange.consumer.receita

- Leitor da fila transacoes que faz exchange caso a transacao tenha + de 40k se não imprime a transação no console
    exchange.consumer.transacao
