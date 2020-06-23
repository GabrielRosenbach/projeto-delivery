package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Cliente;

public interface ClienteDAO {

	Cliente salvar(Cliente entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	Cliente buscarPorId(Integer codigo);
	
	List<Cliente> buscarTodos() throws CloneNotSupportedException;
}
