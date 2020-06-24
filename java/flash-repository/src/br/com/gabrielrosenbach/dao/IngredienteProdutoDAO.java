package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;

public interface IngredienteProdutoDAO {

	public List<IngredienteProduto> salvar(Integer codigoProduto, List<Integer> codigoIngredientes);
	
	Boolean excluir(Integer codigo);
	
	IngredienteProduto buscarPorId(Integer codigo);
	
	List<IngredienteProduto> buscarTodos() throws CloneNotSupportedException;

	List<Ingrediente> buscarIngredientes(Integer codigoProduto) throws CloneNotSupportedException;
}
