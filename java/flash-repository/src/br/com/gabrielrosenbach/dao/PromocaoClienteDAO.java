package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.PromocaoCliente;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public interface PromocaoClienteDAO {

	public void salvar(Integer codigoPromocao, List<PromocaoCliente> entidades) throws CloneNotSupportedException, CadastroNaoEncontradoException;
	
	Boolean excluir(Integer codigo);
	
	PromocaoCliente buscarPorId(Integer codigo) throws CloneNotSupportedException;
	
	List<PromocaoCliente> buscarTodos() throws CloneNotSupportedException;
}
