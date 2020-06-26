package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;

public interface IngredienteProdutoDAO {

	List<IngredienteProduto> salvar(Integer codigoProduto, List<Integer> codigoIngredientes);
	
	Boolean excluir(Integer codigo);
	
	IngredienteProduto buscarPorId(Integer codigo) throws CadastroNaoEncontradoException;
	
	List<IngredienteProduto> buscarTodos();

	List<Ingrediente> buscarIngredientes(Integer codigoProduto);
}
