package br.com.gabrielrosenbach.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum TipoDescontoEnum {
	
	PRECO_FIXO(1, "Preço Fixo"), PORCENTAGEM(2, "Porcentagem");

	private Integer valor;
	private String descricao;

	private static final Map<Integer, TipoDescontoEnum> buscaPorValor = new HashMap<>();

	static {
		for (TipoDescontoEnum tipoDescontoEnum : TipoDescontoEnum.values()) {
			buscaPorValor.put(tipoDescontoEnum.getValor(), tipoDescontoEnum);
		}
	}

	private TipoDescontoEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoDescontoEnum get(Integer valor) {
		return TipoDescontoEnum.buscaPorValor.get(valor);
	}

}
