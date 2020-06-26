package br.com.gabrielrosenbach.dto;

public class PesquisaDTO {
	
	private String pesquisa;

	public PesquisaDTO(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
}
