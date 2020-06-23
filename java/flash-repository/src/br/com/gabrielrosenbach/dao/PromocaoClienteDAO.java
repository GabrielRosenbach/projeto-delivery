package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.PromocaoCliente;

public interface PromocaoClienteDAO {

	PromocaoCliente salvar(PromocaoCliente entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	PromocaoCliente buscarPorId(Integer codigo);
	
	List<PromocaoCliente> buscarTodos() throws CloneNotSupportedException;
}
