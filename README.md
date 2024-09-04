# Trabalho2-Topicos

trabalho para a matéria de tópicos avançados, para ser avaliado. 

#### Projeto RabbitMQ - Consumer e Producer com CSV

## Responsabilidades de cada Aplicação

### Ler o arquivo transacoes.csv

1. #### exchange.producer.lerCSV: 
Produtor com leitor de CSV

### Fazer o exchange intermediário

2. #### exchange.producer.transacao:
Faz o exchange de transacoes.suspeitas com as filas policia.federal e receita.federal

3. #### exchange.consumer.transacao:
Leitor da fila transacoes que faz exchange caso a transacao tenha + de 40k se não imprime a transação no console

### Leitores para policia e receita federal

4. #### exchange.consumer.policia:
Leitor da fila federal.policia
    
5. #### exchange.consumer.receita:
Leitor da fila federal.receita
    

