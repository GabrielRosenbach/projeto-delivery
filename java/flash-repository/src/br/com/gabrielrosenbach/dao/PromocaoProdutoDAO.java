package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.PromocaoProduto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public interface PromocaoProdutoDAO {

	public void salvar(Integer codigoPromocao, List<PromocaoProduto> entidades) throws CloneNotSupportedException, CadastroNaoEncontradoException;
	
	Boolean excluir(Integer codigo);
	
	PromocaoProduto buscarPorId(Integer codigo);
	
	List<PromocaoProduto> buscarTodos() throws CloneNotSupportedException;
}
