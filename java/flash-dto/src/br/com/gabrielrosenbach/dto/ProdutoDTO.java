package br.com.gabrielrosenbach.dto;

import java.util.List;

import br.com.gabrielrosenbach.enumerator.TipoProdutoEnum;

public class ProdutoDTO extends GenericDTO {

	private String nome;
	private Double preco;
	private Integer porcao;
	private Double medida;
	private Integer tipo;
	private List<Integer> ingredientes;

	public ProdutoDTO(Integer codigo, String nome, Double preco, Integer porcao, Double medida, Integer tipo,
			List<Integer> ingredientes) {
		super(codigo);
		this.nome = nome;
		this.preco = preco;
		this.porcao = porcao;
		this.medida = medida;
		this.tipo = tipo;
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getPorcao() {
		return porcao;
	}

	public void setPorcao(Integer porcao) {
		this.porcao = porcao;
	}

	public Double getMedida() {
		return medida;
	}

	public void setMedida(Double medida) {
		this.medida = medida;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<Integer> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Integer> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public String toString() {
		return "Produto: " + nome + ", Preço: R$" + String.format("%.2f", preco) + ", Porção: " + porcao + ", Medida: "
				+ medida + (tipo.equals(TipoProdutoEnum.LIQUIDO.getValor()) ? "ml" : "g") + ", Tipo: "
				+ TipoProdutoEnum.get(tipo).getDescricao() + ", Código: " + getCodigo();
	}

	public String toStringIngredientes() {
		return "Produto: " + nome + ", Ingredientes: " + ingredientes;
	}
}
