package br.com.cadastro.enum1;

public enum TipoTelefone {

	CELULAR(0, "Celular"), 
	TELEFONE(1, "Telefone");

	private final int id;
	private final String descricao;

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	TipoTelefone(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;

	}

}
