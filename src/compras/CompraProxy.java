package compras;

import persons.Cliente;
import pizzas.Pizza;

public class CompraProxy implements CompraService {

	private CompraRealService compraReal;
	private double saldo;
	
	// construtor
	public CompraProxy(double saldo) {
		this.compraReal = new CompraRealService();
		this.saldo = saldo;
	}
	
	
	// verifica se existe saldo suficiente e então chama a funcao de comprar verdadeira
	@Override
	public void buy(Pizza pizza, Cliente cliente) {
		if(pizza.preco() <= this.saldo) {
			this.compraReal.buy(pizza, cliente);
		}else {
			System.out.println("Compra recusada, saldo insuficiente.");
		}
		// TODO Auto-generated method stub

	}

}
