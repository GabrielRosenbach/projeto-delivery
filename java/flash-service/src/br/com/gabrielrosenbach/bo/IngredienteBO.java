package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.IngredienteDTO;

public interface IngredienteBO {

	IngredienteDTO salvar(IngredienteDTO entidade);

	Boolean excluir(Integer codigo);

	IngredienteDTO buscarPorId(Integer codigo);

	List<IngredienteDTO> buscarTodos();
}
