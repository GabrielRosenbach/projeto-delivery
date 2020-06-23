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
	public PromocaoProduto salvar(PromocaoProduto entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			PromocaoProduto antigo = buscaInterna(entidade);
			antigo.setProduto(entidade.getProduto());
			antigo.setPromocao(entidade.getPromocao());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private PromocaoProduto buscaInterna(PromocaoProduto entidade) {
		Optional<PromocaoProduto> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
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
