package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.IngredienteProduto;

public interface IngredienteProdutoDAO {

	IngredienteProduto salvar(IngredienteProduto entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	IngredienteProduto buscarPorId(Integer codigo);
	
	List<IngredienteProduto> buscarTodos() throws CloneNotSupportedException;
}
