package br.com.wagner.banco.conta;

import br.com.wagner.banco.Banco;
import br.com.wagner.banco.cliente.Cliente;

public class ContaPoupanca extends Conta {
	
	private static final Integer VARIACAO = 51;
	
	private Integer variacao;

	public ContaPoupanca(Banco banco, Cliente cliente) {
		super(banco, cliente);
		this.variacao = VARIACAO;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("**** Extrato Conta Poupança ***");
		System.out.println("Variação: " + this.variacao);
		super.imprimirExtratoComum();
		System.out.println("*******************************\n");
	}

	public Integer getVariacao() {
		return variacao;
	}

	@Override
	public void obterEmprestimo(Double valor) {
		System.out.println("Empréstimo ainda não disponível para Conta Poupança.");
	}

}
