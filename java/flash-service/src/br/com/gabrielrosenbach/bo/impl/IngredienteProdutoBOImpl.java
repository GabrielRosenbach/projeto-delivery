package br.com.gabrielrosenbach.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteProdutoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.IngredienteProdutoDAO;
import br.com.gabrielrosenbach.dao.impl.IngredienteDAOImpl;
import br.com.gabrielrosenbach.dao.impl.IngredienteProdutoDAOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.IngredienteProdutoDTO;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;

public class IngredienteProdutoBOImpl implements IngredienteProdutoBO {

	IngredienteDAO ingredienteDAO = new IngredienteDAOImpl();

	IngredienteProdutoDAO ingredienteProdutoDAO = new IngredienteProdutoDAOImpl();

	@Override
	public List<IngredienteProdutoDTO> salvar(Integer codigoProduto, List<Integer> codigosIngredientes) {
		
		List<IngredienteProduto> list = ingredienteProdutoDAO.salvar(codigoProduto, codigosIngredientes);
		return DtoConverter.IngredienteProdutoToIngredienteProdutoDTO(list);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return ingredienteDAO.excluir(codigo);
	}

	@Override
	public IngredienteProdutoDTO buscarPorId(Integer codigo) {
		return DtoConverter.IngredienteProdutoToIngredienteProdutoDTO(ingredienteProdutoDAO.buscarPorId(codigo));
	}

	@Override
	public List<IngredienteProdutoDTO> buscarTodos() {
		List<IngredienteProduto> list = new ArrayList<>();
		try {
			list = ingredienteProdutoDAO.buscarTodos();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return DtoConverter.IngredienteProdutoToIngredienteProdutoDTO(list);
	}

	@Override
	public List<IngredienteDTO> buscarIngredientes(Integer codigoProduto) {
		List<Ingrediente> listaRetorno = new ArrayList<>();
		try {
			listaRetorno = ingredienteProdutoDAO.buscarIngredientes(codigoProduto);
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return DtoConverter.IngredienteToIngredienteDTO(listaRetorno);
	}
}
