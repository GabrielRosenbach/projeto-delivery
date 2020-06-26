package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.exception.PedidoNaoEstaMaisEmEsperaException;
import br.com.gabrielrosenbach.model.Pedido;

public interface PedidoDAO {

	Pedido salvar(Pedido pedido);

	Boolean excluir(Integer codigo) throws PedidoNaoEstaMaisEmEsperaException;

	Pedido buscarPorId(Integer codigo) throws CadastroNaoEncontradoException, CloneNotSupportedException;

	List<Pedido> buscarTodos();
	
	Boolean alterarStatus(Integer codigoPedido, Integer codigoStatus) throws CadastroNaoEncontradoException;
}
