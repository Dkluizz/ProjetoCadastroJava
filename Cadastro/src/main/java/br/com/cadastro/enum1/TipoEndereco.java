package br.com.cadastro.enum1;

public enum TipoEndereco {
	AVENIDA(1, "Avenida"),
	RUA(2, "Rua"),
	CONDOMINIO(3, "Condominio");
	
	private final int id;
	private final String descricao;

	TipoEndereco(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return this.id;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	
	

    
}
