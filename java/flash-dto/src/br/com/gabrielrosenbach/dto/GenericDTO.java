package br.com.gabrielrosenbach.dto;

public class GenericDTO {

	private Integer codigo;
	
	public GenericDTO(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		if (this.codigo == null) {
			this.codigo = codigo;
		}
	}
}
