package br.com.gabrielrosenbach.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum TipoPromocaoEnum {
	
	DESCONTO_EM_PRODUTO(1, "Desconto Em Produto"), DESCONTO_PARA_CLIENTE(2, "Desconto Para Cliente"), BRINDE_PARA_CLIENTE(3, "Brinde Para Cliente");

	private Integer valor;
	private String descricao;

	private static final Map<Integer, TipoPromocaoEnum> buscaPorValor = new HashMap<>();

	static {
		for (TipoPromocaoEnum tipoPromocaoEnum : TipoPromocaoEnum.values()) {
			buscaPorValor.put(tipoPromocaoEnum.getValor(), tipoPromocaoEnum);
		}
	}

	private TipoPromocaoEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPromocaoEnum get(Integer valor) {
		return TipoPromocaoEnum.buscaPorValor.get(valor);
	}
}
