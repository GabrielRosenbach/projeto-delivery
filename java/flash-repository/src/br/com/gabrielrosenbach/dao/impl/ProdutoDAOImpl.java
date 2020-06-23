package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class ProdutoDAOImpl implements ProdutoDAO {

	private static List<Produto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Produto salvar(Produto entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			Produto antigo = buscaInterna(entidade);
			antigo.setMedida(entidade.getMedida());
			antigo.setNome(entidade.getNome());
			antigo.setPreco(entidade.getPreco());
			antigo.setTipo(entidade.getTipo());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Produto buscaInterna(Produto entidade) {
		Optional<Produto> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Produto buscarPorId(Integer codigo) {
		Optional<Produto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Produto> buscarTodos() throws CloneNotSupportedException {
		List<Produto> novaLista = new ArrayList<>();

		for (Produto entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
