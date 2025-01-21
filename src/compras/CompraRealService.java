package compras;

import persons.Cliente;
import pizzas.Pizza;

public class CompraRealService implements CompraService {

	// Pagar pizza e atualizar saldo do cliente
	@Override
	public void buy(Pizza pizza, Cliente cliente) {
		System.out.println(pizza.nome() + " comprada pelo " + cliente.name + " por: R$" + pizza.preco());
		cliente.comprar(pizza.preco());
		pizza.doPizza();
	}

}
