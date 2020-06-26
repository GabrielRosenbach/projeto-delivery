package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.model.PromocaoProduto;

public interface PromocaoProdutoDAO {

	List<PromocaoProduto> salvar(Integer codigoPromocao, List<Integer> codigoProdutos);
	
	Boolean excluir(Integer codigo);
	
	PromocaoProduto buscarPorId(Integer codigo);
	
	List<PromocaoProduto> buscarTodos();
	
	List<Produto> buscarProdutos(Integer codigoPromocao);
}
