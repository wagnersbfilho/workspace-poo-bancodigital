package br.com.wagner;

import br.com.wagner.banco.Banco;
import br.com.wagner.banco.EBanco;
import br.com.wagner.banco.cliente.Cliente;
import br.com.wagner.banco.conta.Conta;
import br.com.wagner.banco.conta.ContaCorrente;
import br.com.wagner.banco.conta.ContaPoupanca;

public class Principal {

	public static void main(String[] args) {
		
		Conta ccWagner = criarContaCorrente(EBanco.BB, "Wagner");
		Conta pouWagner = criarContaPoupanca(EBanco.BB, "Wagner");
		ccWagner.depositar(100d);
		ccWagner.transferir(ccWagner.getSaldo(), pouWagner);
		
		Conta ccFulano = criarContaCorrente(EBanco.CAIXA, "Fulano");
		ccFulano.depositar(500d);
		ccFulano.transferir(150d, ccWagner);
		ccFulano.obterEmprestimo(100d);

		ccWagner.imprimirExtrato();
		pouWagner.imprimirExtrato();
		ccFulano.imprimirExtrato();
}
	
	/**
	 * Criar uma conta corrente.
	 * 
	 * @param enumBanco
	 * @param nomeCliente
	 * @return
	 */
	private static Conta criarContaCorrente(EBanco enumBanco, String nomeCliente) {
		
		Banco banco = cadastrarBanco(enumBanco);
		Cliente cliente = cadastrarCliente(nomeCliente);
		Conta cc = new ContaCorrente(banco, cliente);
		return cc;
	}

	/**
	 * Criar uma conta poupança.
	 * 
	 * @param enumBanco
	 * @param nomeCliente
	 * @return
	 */
	private static Conta criarContaPoupanca(EBanco enumBanco, String nomeCliente) {
		
		Banco banco = cadastrarBanco(enumBanco);
		Cliente cliente = cadastrarCliente(nomeCliente);
		Conta poupanca = new ContaPoupanca(banco, cliente);
		return poupanca;
	}

	private static Cliente cadastrarCliente(String nomeCliente) {
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		return cliente;
	}

	private static Banco cadastrarBanco(EBanco enumBanco) {
		Banco banco = new Banco (enumBanco.codigo, enumBanco.name());
		return banco;
	}
}
