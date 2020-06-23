package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.PromocaoProduto;

public interface PromocaoProdutoDAO {

	PromocaoProduto salvar(PromocaoProduto entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	PromocaoProduto buscarPorId(Integer codigo);
	
	List<PromocaoProduto> buscarTodos() throws CloneNotSupportedException;
}
