# Spring Kafka - Exercício de consolidação

## Vamos construir uma aplicação com as seguintes funcionalidades básicas:

- Cadastrar um cliente (código, nome) e listar os clientes. Vamos pensar em um
Controller para estas duas funcionalidades. O Cliente deve ser cadastrado no
MongoDB;
- Cadastrar um produto (código, nome) e listar produtos. Vamos pensar em um
Controller para estas duas funcionalidades. O Produto deve ser cadastrado no
MongoDB;
- Fazer um pedido (cliente, lista de produtos sendo pedidos). Os pedidos são
enviados para um tópico Kafka. Estes pedidos são consumidos por um Consumer
e armazenados no MongoDb;
- Uma funcionalidade busca pedido por código, que retorna o pedidos
armazenado no BD com aquele código.