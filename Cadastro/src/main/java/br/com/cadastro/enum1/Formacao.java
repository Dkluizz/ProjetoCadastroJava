package br.com.cadastro.enum1;

public enum Formacao {

	ENS_FUNDAMENTAL_COMPLETO(1, "Ens Fundamental Completo"), 
	ENS_MEDIO_INCOMPLETO(2, "Ens Médio Incompleto"),
	ENS_MEDIO_COMPLETO(3, "Ens Médio Completo"), 
	ENS_SUPERIOR_INCOMPLETO(4, "Ens Superior Incompleto"),
	ENS_SUPERIOR_COMPLETO(5, "Ens Superior Completo");
	
	private final int id;
	private  final String descricao;

	Formacao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	

	
	
}
