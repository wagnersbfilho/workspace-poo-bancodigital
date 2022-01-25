package br.com.wagner.banco.conta;

public interface IConta {

	public void sacar(Double valor);
	
	public void depositar(Double valor);
	
	public void transferir(Double valor, Conta contaDestino);
	
	public void imprimirExtrato();
	
	public void obterEmprestimo(Double valor);
}
