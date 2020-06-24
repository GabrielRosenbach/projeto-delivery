package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.IngredienteProdutoDTO;

public interface IngredienteProdutoBO {

	List<IngredienteProdutoDTO> salvar(Integer codigoProduto, List<Integer> codigosIngredientes);

	Boolean excluir(Integer codigo);

	IngredienteProdutoDTO buscarPorId(Integer codigo);

	List<IngredienteProdutoDTO> buscarTodos();
	
	List<IngredienteDTO> buscarIngredientes(Integer codigoProduto);

}
