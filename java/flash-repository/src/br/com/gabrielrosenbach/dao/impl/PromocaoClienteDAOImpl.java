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
	public void salvar(Integer codigoPromocao, List<PromocaoCliente> entidades) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		lista.removeIf(x -> x.getPromocao().getCodigo().equals(codigoPromocao));
		for (PromocaoCliente pc : entidades) {
			pc.setCodigo(autoIncrement);
			autoIncrement++;
		}
		lista.addAll(entidades);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	@Override
	public PromocaoCliente buscarPorId(Integer codigo) throws CloneNotSupportedException {
		Optional<PromocaoCliente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get().clone();
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
