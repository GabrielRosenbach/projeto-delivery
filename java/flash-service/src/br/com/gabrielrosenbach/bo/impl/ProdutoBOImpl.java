package br.com.gabrielrosenbach.bo.impl;

import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteBO;
import br.com.gabrielrosenbach.bo.IngredienteProdutoBO;
import br.com.gabrielrosenbach.bo.ProdutoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.impl.ProdutoDAOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.ProdutoDTO;
import br.com.gabrielrosenbach.model.Produto;

public class ProdutoBOImpl implements ProdutoBO {

	ProdutoDAO produtoDAO = new ProdutoDAOImpl();

	IngredienteProdutoBO ingredienteProdutoBO = new IngredienteProdutoBOImpl();

	IngredienteBO IngredienteBO = new IngredienteBOImpl();

	@Override
	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {

		Produto produto = new Produto(produtoDTO.getCodigo(), produtoDTO.getNome(), produtoDTO.getPreco(), produtoDTO.getPorcao(), produtoDTO.getMedida(), produtoDTO.getTipo());
		produto = produtoDAO.salvar(produto);

		ingredienteProdutoBO.salvar(produto.getCodigo(), produtoDTO.getIngredientes());

		return DtoConverter.ProdutoToProdutoDTO(produto);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return produtoDAO.excluir(codigo);
	}

	@Override
	public ProdutoDTO buscarPorId(Integer codigo) {
		ProdutoDTO produtoDTO = null;
		try {
			produtoDTO = DtoConverter.ProdutoToProdutoDTO(produtoDAO.buscarPorId(codigo));
		} catch (CadastroNaoEncontradoException | CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return produtoDTO;
	}

	@Override
	public List<ProdutoDTO> buscarTodos() {
		return DtoConverter.ProdutoToProdutoDTO(produtoDAO.buscarTodos());
	}

	@Override
	public List<IngredienteDTO> buscarIngredientes(Integer codigoProduto) {
		return ingredienteProdutoBO.buscarIngredientes(codigoProduto);
	}
}
