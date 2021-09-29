package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import model.Excecao.DominioExcecao;
import model.entidades.Conta;

public class Principal {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
		System.out.println("Entre com os dados da conta ");
		
		Date dataCadastro = new Date();
		Random random = new Random();
		int numeroConta = random.nextInt(100);
		System.out.print("\nNome Titular: ");
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Valor limite para saque: ");
		double limiteDeRetirada = sc.nextDouble();
		
		Conta conta = new Conta(numeroConta, titular, saldo, limiteDeRetirada, dataCadastro);
		
		System.out.print("\nDeseja realizar outra ação em sua conta ? (s/n)\n");
		char validacao = sc.next().charAt(0);
				
		while(validacao == 's') {
		  
			System.out.println("Deposito(1)");
			System.out.println("Saque(2)");
			System.out.println("Dados da conta(3)");
			
			System.out.print("Informe a opção desejada: ");
			int valid = sc.nextInt();
			
			if(valid == 1) {
				
				System.out.print("\nQual o valor do deposito: ");
				double quantia = sc.nextDouble();
				conta.deposito(quantia);
			}
			else if(valid == 2) {
				System.out.print("\nQual o valor do saque: ");
				double quantia = sc.nextDouble();
				conta.saque(quantia);
			}
			else {
				System.out.println(conta);
			}
			
			System.out.print("Deseja realizar outra ação em sua conta ? (s/n)\n");
			validacao = sc.next().charAt(0);
			
		}
		
		}
		catch(DominioExcecao e){
			System.out.println("Erro nos dados: " + e.getMessage());
		}
		catch(RuntimeException e){
			System.out.println("Erro inesperado");
		}
		
		
		sc.close();
	}

}
