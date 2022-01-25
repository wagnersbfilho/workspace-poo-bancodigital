package br.com.wagner.banco;

import java.util.List;

import br.com.wagner.banco.conta.Conta;

public class Banco {

	private String codigo;
	private String nome;
	private List<Conta> contas;
	
	public Banco(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Banco: " + this.codigo + " - " + this.nome;
	}
}
