package br.com.cadastro.enum1;

public enum Nacionalidade {
	
	NEGRO(0, "Negro"),
	PARDO(1, "Pardo"),
	BRANCO(2, "Branco"),
	AMARELO(3, "Amarelo"),
	INDIGENA(4, "Indigena");

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
