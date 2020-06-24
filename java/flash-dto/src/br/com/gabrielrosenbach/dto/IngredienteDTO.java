package br.com.gabrielrosenbach.dto;

public class IngredienteDTO extends GenericDTO {
	
	private String nome;

	public IngredienteDTO(Integer codigo, String nome) {
		super(codigo);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Ingrediente: " + nome + ", Código: " + getCodigo();
	}
}
