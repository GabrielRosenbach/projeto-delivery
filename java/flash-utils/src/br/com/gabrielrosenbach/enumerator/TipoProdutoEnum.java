package br.com.gabrielrosenbach.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum TipoProdutoEnum {

	PRATO(1, "Prato"), LIQUIDO(2, "Líquido"), CONDIMENTO(3, "Condimento");

	private Integer valor;
	private String descricao;

	private static final Map<Integer, TipoProdutoEnum> buscaPorValor = new HashMap<>();

	static {
		for (TipoProdutoEnum tipoProdutoEnum : TipoProdutoEnum.values()) {
			buscaPorValor.put(tipoProdutoEnum.getValor(), tipoProdutoEnum);
		}
	}

	private TipoProdutoEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoProdutoEnum get(Integer valor) {
		return TipoProdutoEnum.buscaPorValor.get(valor);
	}

}
