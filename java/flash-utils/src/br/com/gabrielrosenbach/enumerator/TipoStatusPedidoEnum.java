package br.com.gabrielrosenbach.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum TipoStatusPedidoEnum {

	EM_ESPERA(1, "Em Espera"), PREPARANDO(2, "Preparando"), PRONTO_PARA_SER_ENTREGUE(3, "Pronto Para Ser Entregue"),
	TRANSPORTANDO(4, "Transportando"), ENTREGUE(5, "Entregue"), IMPREVISTO_NO_PREPARO(6, "Imprevisto No Preparo"),
	IMPREVISTO_NO_TRANSPORTE(7, "Imprevisto No Transporte");

	private Integer valor;
	private String descricao;

	private static final Map<Integer, TipoStatusPedidoEnum> buscaPorValor = new HashMap<>();

	static {
		for (TipoStatusPedidoEnum tipoDescontoEnum : TipoStatusPedidoEnum.values()) {
			buscaPorValor.put(tipoDescontoEnum.getValor(), tipoDescontoEnum);
		}
	}

	private TipoStatusPedidoEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoStatusPedidoEnum get(Integer valor) {
		return TipoStatusPedidoEnum.buscaPorValor.get(valor);
	}

}
