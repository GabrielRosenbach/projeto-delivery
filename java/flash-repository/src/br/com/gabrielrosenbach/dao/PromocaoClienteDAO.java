package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.model.PromocaoCliente;

public interface PromocaoClienteDAO {

	List<PromocaoCliente> salvar(Integer codigoPromocao, List<Integer> codigoClientes);

	Boolean excluir(Integer codigo);

	PromocaoCliente buscarPorId(Integer codigo);

	List<PromocaoCliente> buscarTodos();

	List<Promocao> buscarPromocoes(Integer codigoCliente);
}
