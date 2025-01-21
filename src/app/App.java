package app;

import java.util.ArrayList;
import java.util.Scanner;

import compras.CompraProxy;
import compras.CompraService;
import creators.PizzaBaconCreator;
import creators.PizzaCalabresaCreator;
import creators.PizzaCostelaCreator;
import creators.PizzaFrangoCreator;
import creators.PizzaPortuguesaCreator;
import persons.Admin;
import persons.Cliente;
import pizzas.Pizza;

public class App {

	public static void showPizzas(ArrayList<Pizza> pizzas) {
		int i = 1;
		for(Pizza pizza : pizzas) {
			System.out.println(i + ". Nome: " + pizza.nome() + " | Preço: " + pizza.preco());
			i++;
		}
	}
	
	public static void addDesconto(ArrayList<Pizza> pizzas, Scanner entrada) {
		showPizzas(pizzas);
		System.out.println("0. Sair");
		
		while(true) {
			System.out.println("Qual pizza vai receber o desconto?");
			int escolha = 0;
			
			if(entrada.hasNextInt()) {
				escolha = entrada.nextInt();
				if(escolha > 0 && escolha <= pizzas.size()) {
					Pizza pizza = pizzas.get(escolha-1);
					System.out.println("Qual o desconto da nova pizza em %?");
					double desconto = entrada.nextDouble();
					pizza.pizzaDesconto(1 - (desconto/100));
					break;					
				}else if(escolha == 0){
					break;
				}else {
					System.out.println("Esse indíce de pizza não existe!");
				}
			}else {
				System.out.println("Esse número não corresponde a nenhuma pizza!");
			}
		}
	}
	
	public static void atualizarSaldo(Cliente cliente, Scanner entrada) {
		
		while(true) {
			System.out.println("Quanto de saldo deseja adicionar?");
			if(entrada.hasNextDouble()) {
				double valor = entrada.nextDouble();
				
				cliente.adicionarSaldo(valor);		
				
				break;
			}else {
				System.out.println("Digite um valor númerico!");
			}			
		}
		
	}
	
	public static void buyPizza(Cliente cliente, ArrayList<Pizza> pizzas, Scanner entrada) {
		showPizzas(pizzas);
		System.out.println("0. Sair");
		
		while(true) {
			System.out.println("Qual pizza você deseja comprar?");
			if(entrada.hasNextInt()) {
				int escolha = entrada.nextInt();
				if(escolha > 0 && escolha <= pizzas.size()) {
					Pizza pizza = pizzas.get(escolha-1);				
					CompraService compra = new CompraProxy(cliente.saldo());
					compra.buy(pizza, cliente);
					break;
				}else if(escolha == 0){
					break;
				}else {
					System.out.println("Esse indíce de pizza não existe!");
				}
			}else {			
				System.out.println("Digite um o número da Pizza!");
			}
		}
	}
	
	
	// Mostra as pizzas que não estão nos favoritos e você pode adicionar
	public static void addFavoritePizza(Cliente cliente, ArrayList<Pizza> pizzas, Scanner entrada) {
		ArrayList<Pizza> refPizzas = new ArrayList<Pizza>();
		for(Pizza pizza : pizzas)
		{
			if(!pizza.getObserver(cliente)) {
				refPizzas.add(pizza);
			}
		}
		
		showPizzas(refPizzas);
		System.out.println("0. Sair");
		
		while(true) {
			System.out.println("Qual pizza você deseja receber notificação?");
			if(entrada.hasNextInt()) {
				int escolha = entrada.nextInt();
				if(escolha > 0 && escolha <= refPizzas.size()) {
					Pizza pizza = refPizzas.get(escolha-1);				
					pizza.attach(cliente);
					break;
				}else if (escolha == 0) {
					break;
				}else {
					System.out.println("Esse indíce de pizza não existe!");
				}
			}else {			
				System.out.println("Digite um o número de uma Pizza!");
			}
		}
	}
	
	public static void removeFavoritePizza(Cliente cliente, ArrayList<Pizza> pizzas, Scanner entrada) {
		ArrayList<Pizza> refPizzas = new ArrayList<Pizza>();
		for(Pizza pizza : pizzas)
		{
			if(pizza.getObserver(cliente)) {
				refPizzas.add(pizza);
			}
		}
		
		
		showPizzas(refPizzas);
		System.out.println("0. Sair");
		
		while(true) {
			System.out.println("Qual pizza você deseja remover notificação?");
			if(entrada.hasNextInt()) {
				int escolha = entrada.nextInt();
				if(escolha > 0 && escolha <= refPizzas.size()) {
					Pizza pizza = pizzas.get(escolha-1);				
					pizza.detach(cliente);
					break;
				}else if(escolha == 0){
					break;
				}else {
					System.out.println("Esse indíce de pizza não existe!");
				}
			}else {			
				System.out.println("Digite o número de uma Pizza!");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Pizza calabresa = new PizzaCalabresaCreator().factoryMethod();
		Pizza bacon = new PizzaBaconCreator().factoryMethod();
		Pizza portuguesa = new PizzaPortuguesaCreator().factoryMethod();
		Pizza frango = new PizzaFrangoCreator().factoryMethod();
		Pizza costela = new PizzaCostelaCreator().factoryMethod();
		
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas.add(calabresa);
		pizzas.add(bacon);
		pizzas.add(portuguesa);
		pizzas.add(frango);
		pizzas.add(costela);
		
		ArrayList<Cliente> users = new ArrayList<Cliente>();
		
		
		while(true) {
			Cliente user = null;
			Admin admin = null;
			
			System.out.println("##############################");
			System.out.println("##############################");
			System.out.println();
			System.out.println("Bem vindo a Pizzaria do Freddy");
			System.out.println();
			System.out.println("##############################");
			System.out.println("##############################");
			System.out.println();
			System.out.println("digite \"sair\" para sair...");
			System.out.println();
			
			
			System.out.print("Usuario: ");
			String login = entrada.next();
			System.out.println();
			System.out.print("Senha: ");
			String pass = entrada.next();
			
			if(login.equals("sair") || pass.equals("sair")) {
				break;
			}
			
			if(login.equals("admin") && pass.equals("admin")) {
				admin = new Admin();
			}else {
				for(Cliente cliente : users) {
					if(cliente.name.equals(login) && cliente.password().equals(pass)) {
						user = cliente;
						break;
					}
				}
				
				if(user == null) {
					user = new Cliente(login, pass);
					users.add(user);					
				}
			}
			
			while(true) {
				
				if(admin != null) {
					System.out.println();
					System.out.println("############## BEM VINDO ADMIN ################");
					System.out.println("1. Ver Pizzas ");
					System.out.println("2. Adicionar Desconto ");
					System.out.println("3. Sair ");
					System.out.println("#####################");
					String escolha = entrada.next();
					
					switch(escolha.toLowerCase()) {
					case "1": showPizzas(pizzas) ;break;
					case "2": addDesconto(pizzas, entrada) ;break;
					case "3": System.out.println("Até mais admin");break;
					default: System.out.println("Escolha uma das opções");
					}
					
					System.out.println("");
					if(escolha.equals("3")) {
						break;
					}
				}
				
				if(user != null) {
					
					System.out.println();
					System.out.println("############## BEM VINDO " + user.name + " ################");
					System.out.println("1. Ver Pizzas ");
					System.out.println("2. Ver saldo ");
					System.out.println("3. Atualizar Saldo ");
					System.out.println("4. Comprar Pizza");
					System.out.println("5. Adicionar Pizza aos Favoritos");
					System.out.println("6. Remover Pizza dos Favoritos");
					System.out.println("7. Sair ");
					System.out.println("#####################");
					String escolha = entrada.next();
					
					switch(escolha.toLowerCase()) {
					case "1": showPizzas(pizzas);break;
					case "2": System.out.println("Seu Saldo é de: " + user.saldo());break;
					case "3": atualizarSaldo(user, entrada);break;
					case "4": buyPizza(user, pizzas, entrada);break;
					case "5": addFavoritePizza(user, pizzas, entrada); break;
					case "6": removeFavoritePizza(user, pizzas, entrada); break;
					case "7": System.out.println("Até mais " + user.name);
					default: System.out.println("Escolha uma das opções...");
					}
					
					if(escolha.equals("7")) {
						break;
					}
					
				}
				
			}
			
		}
				
		entrada.close();
		System.out.println("Programa encerrado...");
		
	}

}
