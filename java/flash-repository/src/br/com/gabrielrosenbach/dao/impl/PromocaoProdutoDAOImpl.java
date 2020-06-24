package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.PromocaoProdutoDAO;
import br.com.gabrielrosenbach.model.PromocaoProduto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class PromocaoProdutoDAOImpl implements PromocaoProdutoDAO {

	private static List<PromocaoProduto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public void salvar(Integer codigoPromocao, List<PromocaoProduto> entidades) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		lista.removeIf(x -> x.getPromocao().getCodigo().equals(codigoPromocao));
		for (PromocaoProduto pp : entidades) {
			pp.setCodigo(autoIncrement);
			autoIncrement++;
		}
		lista.addAll(entidades);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	@Override
	public PromocaoProduto buscarPorId(Integer codigo) {
		Optional<PromocaoProduto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<PromocaoProduto> buscarTodos() throws CloneNotSupportedException {
		List<PromocaoProduto> novaLista = new ArrayList<>();

		for (PromocaoProduto entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
