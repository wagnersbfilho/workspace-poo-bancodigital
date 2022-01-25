package br.com.wagner.banco;

public enum EBanco {

	BB("001"),
	SANTANDER("033"),
	CAIXA("104"),
	ITAU("341");
	
	public String codigo;

	EBanco(String codigo) {
		this.codigo = codigo;
	}
}
