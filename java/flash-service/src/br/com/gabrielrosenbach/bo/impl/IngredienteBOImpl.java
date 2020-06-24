package br.com.gabrielrosenbach.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.impl.IngredienteDAOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.model.Ingrediente;

public class IngredienteBOImpl implements IngredienteBO {

	IngredienteDAO ingredienteDAO = new IngredienteDAOImpl();

	@Override
	public IngredienteDTO salvar(IngredienteDTO entidade) {
		Ingrediente model = null;
		model = new Ingrediente(entidade.getNome());
		model = ingredienteDAO.salvar(model);

		return DtoConverter.IngredienteToIngredienteDTO(model);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return ingredienteDAO.excluir(codigo);
	}

	@Override
	public IngredienteDTO buscarPorId(Integer codigo) {
		return DtoConverter.IngredienteToIngredienteDTO(ingredienteDAO.buscarPorId(codigo));
	}

	@Override
	public List<IngredienteDTO> buscarTodos() {
		List<Ingrediente> list = new ArrayList<>();
		list = ingredienteDAO.buscarTodos();
		return DtoConverter.IngredienteToIngredienteDTO(list);
	}
}
