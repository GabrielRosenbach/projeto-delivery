package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Pedido;

public interface PedidoDAO {

	Pedido salvar(Pedido entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	Pedido buscarPorId(Integer codigo);
	
	List<Pedido> buscarTodos() throws CloneNotSupportedException;
}
