package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.PromocaoClienteDAO;
import br.com.gabrielrosenbach.model.PromocaoCliente;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class PromocaoClienteDAOImpl implements PromocaoClienteDAO {

	private static List<PromocaoCliente> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public PromocaoCliente salvar(PromocaoCliente entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			PromocaoCliente antigo = buscaInterna(entidade);
			antigo.setPromocao(entidade.getPromocao());
			antigo.setCliente(entidade.getCliente());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private PromocaoCliente buscaInterna(PromocaoCliente entidade) {
		Optional<PromocaoCliente> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public PromocaoCliente buscarPorId(Integer codigo) {
		Optional<PromocaoCliente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<PromocaoCliente> buscarTodos() throws CloneNotSupportedException {
		List<PromocaoCliente> novaLista = new ArrayList<>();

		for (PromocaoCliente entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
