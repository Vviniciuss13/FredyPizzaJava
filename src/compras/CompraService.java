package compras;

import persons.Cliente;
import pizzas.Pizza;

public interface CompraService {

	// Pagar pizza
	void buy(Pizza pizza, Cliente cliente);
	
}
