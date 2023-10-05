package br.com.cadastro.enum1;

public enum Genero {
	
	MASCULINO(0, "Masculino"), 
	FEMININO(1, "Feminino"), 
	NÃO_DECLARADO(2, "Não Declarado");

	private final int id;
	private final String descricao;

	

	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}

	Genero(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

}
