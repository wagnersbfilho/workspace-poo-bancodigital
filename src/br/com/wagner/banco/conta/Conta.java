package br.com.wagner.banco.conta;

import br.com.wagner.banco.Banco;
import br.com.wagner.banco.cliente.Cliente;

public abstract class Conta implements IConta {
	
	private static final Integer AGENCIA_PADRAO = 1;
	private static Integer SEQUENCIAL = 1;

	protected Integer agencia;
	protected Integer numero;
	protected Double saldo;
	protected Cliente cliente;
	protected Banco banco; 
	
	public Conta(Banco banco, Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = 0.0;
		this.banco = banco;
		this.cliente = cliente;
	}	

	@Override
	public void sacar(Double valor) {
		this.saldo -= valor;
	}
	
	@Override
	public void depositar(Double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void transferir(Double valor, Conta contaDestino) {
		sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirExtratoComum() {
		System.out.println(this.banco.toString());
		System.out.println("Titular: " + this.cliente.getNome());
		System.out.println("Agência: " + this.agencia);
		System.out.println("Número: " + this.numero);
		System.out.printf("Saldo: %.2f \n", this.saldo);
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}
	
}
