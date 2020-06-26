package br.com.gabrielrosenbach.dto;

import java.util.List;

public class DadosPromocaoDTO {

	private List<ProdutoDTO> produtos;
	private DescontoDTO desconto;

	public DadosPromocaoDTO(List<ProdutoDTO> produtos, DescontoDTO desconto) {
		this.produtos = produtos;
		this.desconto = desconto;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public DescontoDTO getDesconto() {
		return desconto;
	}

	public void setDesconto(DescontoDTO desconto) {
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "Produtos: " + produtos + "\n Desconto: " + desconto;
	}
}
