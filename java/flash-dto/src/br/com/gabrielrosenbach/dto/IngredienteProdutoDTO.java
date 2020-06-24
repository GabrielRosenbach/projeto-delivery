package br.com.gabrielrosenbach.dto;


public class IngredienteProdutoDTO extends GenericDTO {
	
	private IngredienteDTO ingredienteDTO;
	
	public IngredienteProdutoDTO(Integer codigo, IngredienteDTO ingredienteDTO) {
		super(codigo);
		this.ingredienteDTO = ingredienteDTO;
	}
	
	public IngredienteDTO getIngredienteDTO() {
		return ingredienteDTO;
	}
	
	public void setIngredienteDTO(IngredienteDTO ingredienteDTO) {
		this.ingredienteDTO = ingredienteDTO;
	}

	@Override
	public String toString() {
		return "" + ingredienteDTO;
	}
}
