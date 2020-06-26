package br.com.gabrielrosenbach.dao.exception;

import br.com.gabrielrosenbach.enumerator.TipoProdutoEnum;

public class PedidoNaoEstaMaisEmEsperaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEstaMaisEmEsperaException() {
		super("Pedido já não está mais em espera! Apenas é permitido excluir produtos, que não estão em espera, com o tipo: '"
				+ TipoProdutoEnum.LIQUIDO.getDescricao() + "' ou '" + TipoProdutoEnum.CONDIMENTO.getDescricao() + "'");
	}
}
