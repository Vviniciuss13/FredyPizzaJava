package pizzas;

import java.util.ArrayList;

import persons.Cliente;

public class PizzaFrango implements Pizza {

	private String nome;
	private double preco;
	public int tempo;
	private ArrayList<Cliente> observers = new ArrayList<Cliente>();
	
	// Retorna o preço
	public double preco() {
		return this.preco;
	}
	
	// Retorna o nome
	public String nome() {
		return this.nome;
	}
	
	public boolean getObserver(Cliente observer) {
		return observers.contains(observer);
	}
	
	public PizzaFrango(String nome, double preco, int tempo) {
		this.nome = nome;
		this.preco = preco;
		this.tempo = tempo;
	}
	
	// Faz a pizza
	public void doPizza() {
		System.out.printf("Fazendo Pizza de Frango, irá demorar %d minutos \n", this.tempo);
	}
	
	// Atribui um cliente na pizza favorita
	@Override
	public void attach(Cliente observer) {
		observers.add(observer);
		System.out.println("Pizza de Frango adicionada aos favoritos do " + observer.name);
	}
	
	// Tira um cliente na pizza favorita
	@Override
	public void detach(Cliente observer) {
		observers.remove(observer);
		System.out.println("Pizza de Frango removida dos favoritos do " + observer.name);
	}
		

	// Notifica todos os clientes na pizza favorita
	public void notificar() {
		System.out.println("Notificando os Cliente da Pizza de Frango");
		for(Cliente observer : observers) {
			observer.update(this);
		}
	}
	
	// Adiciona um desconto na pizza e avisa os clientes
	@Override
	public void pizzaDesconto(double desconto) {
		System.out.print("Desconto de ");
		System.out.println(Math.round((1 - desconto) * 100));
		
		this.preco = this.preco * desconto;
		
		System.out.println("Preço da Pizza de Frango atualizado...");
		System.out.println();
		this.notificar();

	}

	
	// muda o preco da pizza e se menor que anterior chama a funcao desconto
	public void setPrice(double value) {
		if(value < this.preco) {
			this.pizzaDesconto(value/this.preco);
			return;
		}
		
		this.preco = value;
	}

}
