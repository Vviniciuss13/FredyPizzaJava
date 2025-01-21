package creators;

import pizzas.Pizza;
import pizzas.PizzaCostela;

public class PizzaCostelaCreator extends Creator {

	public Pizza factoryMethod() {
		return new PizzaCostela("Costela", 70, 50);
	}
	
}
