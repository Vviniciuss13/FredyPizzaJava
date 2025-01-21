package creators;

import pizzas.Pizza;
import pizzas.PizzaCalabresa;

public class PizzaCalabresaCreator extends Creator {

	public Pizza factoryMethod() {
		return new PizzaCalabresa("Calabresa", 60, 40);
	}
}
