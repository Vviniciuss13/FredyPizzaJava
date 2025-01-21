package persons;

import pizzas.Pizza;

public class Cliente{

		public String name;
		private String password;
		private double saldo;
		
		public Cliente(String login, String pass) {
			this.name = login;
			this.password = pass;
		}
		
		public String password() {
			return this.password;
		}
		
		public double saldo() {
			return this.saldo;
		}
		
		public void adicionarSaldo(double valor) {
			this.saldo += valor;
			System.out.println("Valor adicionado com sucesso!");
		}
		
		public void update(Pizza pizza) {
			if(pizza.preco() <= this.saldo) {
				System.out.println(this.name + " a  pizza de " + pizza.nome() + " esta na promoção por R$" + pizza.preco() + "!!!");
			}
		}
		
		public void comprar(double valor) {
			this.saldo = this.saldo - valor;
			System.out.println("O saldo agora é: " + this.saldo);
		}
	
}
