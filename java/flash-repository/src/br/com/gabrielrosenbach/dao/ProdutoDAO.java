package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Produto;

public interface ProdutoDAO {

	Produto salvar(Produto entidade);
	
	Boolean excluir(Integer codigo);
	
	Produto buscarPorId(Integer codigo) throws CadastroNaoEncontradoException, CloneNotSupportedException;
	
	List<Produto> buscarTodos();
}
