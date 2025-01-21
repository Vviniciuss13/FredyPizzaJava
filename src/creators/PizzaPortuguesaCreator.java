package creators;

import pizzas.Pizza;
import pizzas.PizzaPortuguesa;

public class PizzaPortuguesaCreator extends Creator{

	public Pizza factoryMethod() {
		return new PizzaPortuguesa("Portuguesa", 65, 45);
	}
	
}
