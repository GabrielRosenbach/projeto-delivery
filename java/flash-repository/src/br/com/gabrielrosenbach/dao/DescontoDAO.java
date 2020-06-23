package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Desconto;

public interface DescontoDAO {

	Desconto salvar(Desconto entidade) throws CloneNotSupportedException;
	
	Boolean excluir(Integer codigo);
	
	Desconto buscarPorId(Integer codigo);
	
	List<Desconto> buscarTodos() throws CloneNotSupportedException;
}
