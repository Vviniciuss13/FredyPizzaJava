# Fredy Pizza

O sistema desenvolvido para a pizzaria tem como objetivo principal melhorar a interação entre o gerente e os clientes, oferecendo funcionalidades que otimizam a gestão de produtos e as compras no estabelecimento. Utilizando a linguagem de programação Java, e aplicando os padrões de projeto *factory method*, *observer* e *proxy*, o sistema é dividido em dois módulos principais: o módulo do gerente e o módulo do cliente.

## Módulo Gerente

O gerente tem o poder de visualizar todas as pizzas cadastradas no sistema, além de poder aplicar descontos em pizzas específicas. O sistema implementa o padrão de projeto Factory Method, que permite a criação de diferentes tipos de pizzas de forma organizada e eficiente, garantindo flexibilidade na gestão dos produtos. Com esse padrão, o gerente consegue gerenciar facilmente os preços e as variações de desconto das pizzas oferecidas.

## Módulo Cliente

Os clientes podem visualizar todas as pizzas disponíveis, junto aos seus preços atualizados, e realizar compras diretamente através do sistema. Além disso, o cliente pode adicionar pizzas aos seus favoritos, permitindo que ele receba notificações sempre que houver descontos disponíveis para as pizzas que ele gosta. Antes de realizar uma compra, o sistema utiliza uma proxy para verificar se o saldo do cliente é suficiente para a transação, garantindo que ele não faça compras sem o devido crédito

## Padrões de projetos utilizados

No desenvolvimento foi utilizados três padrões de projeto sendo eles:

### Factory Method

No sistema da pizzaria, o padrão de projeto Factory Method é utilizado para criar diferentes tipos de modelos de pizza de forma organizada e flexível. O Factory Method é um padrão de design que define uma interface para a criação de objetos, permitindo que as subclasses decidam qual classe instanciar. Ele permite a criação de objetos de tipos específicos sem a necessidade de especificar exatamente qual classe concreta será usada.

### Observer

Observer que é ideal para situações onde um objeto (o "sujeito" ou subject) precisa notificar múltiplos objetos dependentes (os observadores) sobre mudanças no seu estado, foi utilizado para gerenciar o sistema de pizzas favoritas dos clientes. Quando uma pizza que o cliente selecionou recebe um desconto, o sistema pode notificar o cliente sobre essas mudanças de forma automática se o saldo dele for suficiente para comprar

### Proxy

O padrão de projeto Proxy foi utilizado para controlar o acesso ao processo de pagamento e verificar se o cliente tem saldo suficiente para comprar a pizza. O Proxy atua como um intermediário entre o cliente e o sistema de pagamento realizando a validação do saldo do cliente antes de permitir a compra.

## Conclusão

Esse sistema otimizará uma empresa de Pizzaria a poder com mais agilidade espalhar o seu produto e suas promoções fazendo com que elas sejam notificadas aos seus clientes. Ele dará a possibilidade do seu cliente adicionar suas pizzas favoritas, deixar armazenado saldo nos sistemas, ver as pizzas com seus valores e comprar os produtos dessa pizzaria. Olhando tecnicamente, por ter sido utilizado Factory Method, ele pode expandir as suas pizzas, observadores novos tipos de usuários forem adicionados, e novas validações de acordo com os meios de pagamentos, por exemplo o cartão de crédito.  

# Feito por Carlos Vinícius
