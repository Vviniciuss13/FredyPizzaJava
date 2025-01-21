package pizzas;

import persons.Cliente;

public interface Pizza {

	public String nome();
	
	public double preco();
	
	public boolean getObserver(Cliente oberserver);
	
	public void doPizza();
	
	public void attach(Cliente observer);
	
	public void detach(Cliente observer);
	
	public void notificar();
	
	public void pizzaDesconto(double desconto);
		
}
