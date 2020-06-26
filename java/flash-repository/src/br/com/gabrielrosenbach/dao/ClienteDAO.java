package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Cliente;

public interface ClienteDAO {

	Cliente salvar(Cliente entidade);
	
	Boolean excluir(Integer codigo);
	
	Cliente buscarPorId(Integer codigo) throws CadastroNaoEncontradoException;
	
	List<Cliente> buscarTodos();
	
	Boolean verificarLogin(String email, String senha);
	
	Cliente buscarPorIdentificao(String pesquisa) throws CadastroNaoEncontradoException;
}
