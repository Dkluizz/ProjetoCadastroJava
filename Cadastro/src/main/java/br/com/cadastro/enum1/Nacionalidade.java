package br.com.cadastro.enum1;

public enum Nacionalidade {
	
	NEGRO(1, "Negro"),
	PARDO(2, "Pardo"),
	BRANCO(3, "Branco"),
	AMARELO(4, "Amarelo"),
	INDIGENA(5, "Indigena");

	private final int id;
	private final String descricao;
	
	Nacionalidade(int id, String descricao) {
        this.id = id;
        this.descricao= descricao;
        
    }

	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
