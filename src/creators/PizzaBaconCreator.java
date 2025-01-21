package creators;

import pizzas.Pizza;
import pizzas.PizzaBacon;

public class PizzaBaconCreator extends Creator {

	public Pizza factoryMethod() {
		return new PizzaBacon("Bacon", 50, 30);
	}
	
}
