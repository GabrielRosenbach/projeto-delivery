package br.com.gabrielrosenbach.bo.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteProdutoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.IngredienteProdutoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
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
		return ingredienteProdutoDAO.excluir(codigo);
	}

	@Override
	public IngredienteProdutoDTO buscarPorId(Integer codigo) {
		IngredienteProdutoDTO ingredienteProdutoDTO = null;
		try {
			ingredienteProdutoDTO = DtoConverter.IngredienteProdutoToIngredienteProdutoDTO(ingredienteProdutoDAO.buscarPorId(codigo));
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return ingredienteProdutoDTO;
	}

	@Override
	public List<IngredienteProdutoDTO> buscarTodos() {
		List<IngredienteProduto> list = new ArrayList<>();
		list = ingredienteProdutoDAO.buscarTodos();
		return DtoConverter.IngredienteProdutoToIngredienteProdutoDTO(list);
	}

	@Override
	public List<IngredienteDTO> buscarIngredientes(Integer codigoProduto) {
		List<Ingrediente> listaRetorno = new ArrayList<>();
		listaRetorno = ingredienteProdutoDAO.buscarIngredientes(codigoProduto);
		return DtoConverter.IngredienteToIngredienteDTO(listaRetorno);
	}
}
