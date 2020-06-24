package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Ingrediente;

public interface IngredienteDAO {

	Ingrediente salvar(Ingrediente entidade);
	
	Boolean excluir(Integer codigo);
	
	Ingrediente buscarPorId(Integer codigo);
	
	List<Ingrediente> buscarTodos();
}
