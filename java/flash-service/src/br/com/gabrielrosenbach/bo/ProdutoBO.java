package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.ProdutoDTO;

public interface ProdutoBO {

	ProdutoDTO salvar(ProdutoDTO produtoDTO);
	
	Boolean excluir(Integer codigo);
	
	ProdutoDTO buscarPorId(Integer codigo);
	
	List<ProdutoDTO> buscarTodos();
	
	List<IngredienteDTO> buscarIngredientes(Integer codigoProduto);
}
