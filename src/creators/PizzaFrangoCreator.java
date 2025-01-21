package creators;

import pizzas.Pizza;
import pizzas.PizzaFrango;

public class PizzaFrangoCreator extends Creator {

	public Pizza factoryMethod() {
		return new PizzaFrango("Frango", 50, 30);
	}
	
}
