package br.com.wagner.banco.conta;

import br.com.wagner.banco.Banco;
import br.com.wagner.banco.cliente.Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente(Banco banco, Cliente cliente) {
		super(banco, cliente);
	}

	private Boolean emprestimoSolicitado = Boolean.FALSE;
	private Boolean emprestimoAutorizado;
	private Double valorEmprestimo;
	
	/**
	 * M�todo que verifica a possibilidade de contrair um Empr�stimo.
	 * 
	 * 1) O saldo precisa ser positivo. 
	 * 2) O limite para emp�stimo � no m�xim0 30% o valor do saldo atual.
	 * 3) O juros cobrado � de 2% por empr�stimo.
	 */
	public void obterEmprestimo(Double valor) {
		emprestimoSolicitado = Boolean.TRUE;
		Double limite = super.saldo * 0.3;

		if (super.saldo <= 0 || valor > limite) {
			emprestimoAutorizado = Boolean.FALSE;
		} else {
			emprestimoAutorizado = Boolean.TRUE;
			Double juros = valor * 0.02;
			this.valorEmprestimo = valor + juros;
			super.saldo -= this.valorEmprestimo;
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("**** Extrato Conta Corrente ***");
		if (emprestimoSolicitado) {
			System.out.println("Resultado da solicita��o de empr�stimo:");
			if (emprestimoAutorizado) {
				System.out.printf("- Empr�stimo concedido! Valor debitado com juros R$ %.2f\n", this.valorEmprestimo);
			} else {
				System.out.println("- Empr�stimo n�o autorizado!");
			}
		}

		super.imprimirExtratoComum();
		System.out.println("*******************************\n");
	}
}
