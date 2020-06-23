package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.IngredienteProdutoDAO;
import br.com.gabrielrosenbach.model.IngredienteProduto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class IngredienteProdutoDAOImpl implements IngredienteProdutoDAO {

	private static List<IngredienteProduto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public IngredienteProduto salvar(IngredienteProduto entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			IngredienteProduto antigo = buscaInterna(entidade);
			antigo.setIngrediente(entidade.getIngrediente());
			antigo.setProduto(entidade.getProduto());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private IngredienteProduto buscaInterna(IngredienteProduto entidade) {
		Optional<IngredienteProduto> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public IngredienteProduto buscarPorId(Integer codigo) {
		Optional<IngredienteProduto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<IngredienteProduto> buscarTodos() throws CloneNotSupportedException {
		List<IngredienteProduto> novaLista = new ArrayList<>();

		for (IngredienteProduto entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
