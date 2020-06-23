package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Produto;

public interface ProdutoDAO {

	Produto salvar(Produto entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	Produto buscarPorId(Integer codigo);
	
	List<Produto> buscarTodos() throws CloneNotSupportedException;
}
