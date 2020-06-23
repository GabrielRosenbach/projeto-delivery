package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class IngredienteDAOImpl implements IngredienteDAO {

	private static List<Ingrediente> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Ingrediente salvar(Ingrediente entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			Ingrediente antigo = buscaInterna(entidade);
			antigo.setNome(entidade.getNome());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Ingrediente buscaInterna(Ingrediente entidade) {
		Optional<Ingrediente> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Ingrediente buscarPorId(Integer codigo) {
		Optional<Ingrediente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Ingrediente> buscarTodos() throws CloneNotSupportedException {
		List<Ingrediente> novaLista = new ArrayList<>();

		for (Ingrediente entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
