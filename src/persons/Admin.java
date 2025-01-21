package persons;

import pizzas.Pizza;

public class Admin{

	public String name;

	public void adicionarDesconto(Pizza pizza, double valor) {
		System.out.println("Adicionando desconto...");
		pizza.pizzaDesconto(valor);
	}
	
	
}
