package br.com.gabrielrosenbach.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.impl.IngredienteDAOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.model.Ingrediente;

public class IngredienteBOImpl implements IngredienteBO {

	IngredienteDAO ingredienteDAO = new IngredienteDAOImpl();

	@Override
	public IngredienteDTO salvar(IngredienteDTO entidade) {
		Ingrediente model = null;
		model = new Ingrediente(entidade.getCodigo(), entidade.getNome());
		model = ingredienteDAO.salvar(model);

		return DtoConverter.IngredienteToIngredienteDTO(model);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return ingredienteDAO.excluir(codigo);
	}

	@Override
	public IngredienteDTO buscarPorId(Integer codigo) {
		IngredienteDTO ingredienteDTO = null;
		try {
			ingredienteDTO = DtoConverter.IngredienteToIngredienteDTO(ingredienteDAO.buscarPorId(codigo));
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return ingredienteDTO;
	}

	@Override
	public List<IngredienteDTO> buscarTodos() {
		List<Ingrediente> list = new ArrayList<>();
		list = ingredienteDAO.buscarTodos();
		return DtoConverter.IngredienteToIngredienteDTO(list);
	}
}
