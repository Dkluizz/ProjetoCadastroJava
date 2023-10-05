package br.com.cadastro.enum1;

public enum Formacao {

	ENS_FUNDAMENTAL_COMPLETO(0, "Ens Fundamental Completo"), 
	ENS_MEDIO_INCOMPLETO(1, "Ens Médio Incompleto"),
	ENS_MEDIO_COMPLETO(2, "Ens Médio Completo"), 
	ENS_SUPERIOR_INCOMPLETO(3, "Ens Superior Incompleto"),
	ENS_SUPERIOR_COMPLETO(4, "Ens Superior Completo");
	
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
