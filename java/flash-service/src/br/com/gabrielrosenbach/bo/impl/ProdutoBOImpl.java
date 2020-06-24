package br.com.gabrielrosenbach.bo.impl;

import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteBO;
import br.com.gabrielrosenbach.bo.IngredienteProdutoBO;
import br.com.gabrielrosenbach.bo.ProdutoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.ProdutoDAO;
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
		String nome = produtoDTO.getNome();
		Double preco = produtoDTO.getPreco();
		Integer porcao = produtoDTO.getPorcao();
		Double medida = produtoDTO.getMedida();
		Integer tipo = produtoDTO.getTipo();

		Produto produto = new Produto(nome, preco, porcao, medida, tipo);
		produto = produtoDAO.salvar(produto);

		ingredienteProdutoBO.salvar(produto.getCodigo(), produtoDTO.getIngredientes());

		ProdutoDTO retornoDTO = new ProdutoDTO(produto.getCodigo(), produto.getNome(), preco, porcao, medida, tipo,
				null);
		return retornoDTO;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return produtoDAO.excluir(codigo);
	}

	@Override
	public ProdutoDTO buscarPorId(Integer codigo) {
		return DtoConverter.ProdutoToProdutoDTO(produtoDAO.buscarPorId(codigo));
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
