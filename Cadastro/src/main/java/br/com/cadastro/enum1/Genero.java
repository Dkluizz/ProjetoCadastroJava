package br.com.cadastro.enum1;

public enum Genero {
	
	MASCULINO(1, "Masculino"), 
	FEMININO(2, "Feminino"), 
	NÃO_DECLARADO(3, "Não Declarado");

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
