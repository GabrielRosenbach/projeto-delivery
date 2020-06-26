package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Ingrediente;

public class IngredienteDAOImpl implements IngredienteDAO {

	private static List<Ingrediente> lista = new ArrayList<>();
	private static int autoIncrement = 1;
	
	static {
		IngredienteDAO dao = new IngredienteDAOImpl();
			dao.salvar(new Ingrediente(null, "Alho"));
			dao.salvar(new Ingrediente(null, "Carne Gado"));
			dao.salvar(new Ingrediente(null, "Tomate"));
			dao.salvar(new Ingrediente(null, "Cebola"));
			dao.salvar(new Ingrediente(null, "Pimenta"));
			dao.salvar(new Ingrediente(null, "Batata"));
			dao.salvar(new Ingrediente(null, "Frango"));
			dao.salvar(new Ingrediente(null, "Requeijão"));
			dao.salvar(new Ingrediente(null, "Presunto"));
	}

	@Override
	public Ingrediente salvar(Ingrediente entidade) {
		Ingrediente ingredienteRetorno = null;
		try {
			if (entidade.getCodigo() == null) {
				entidade.setCodigo(autoIncrement);
				autoIncrement++;
				
				lista.add(entidade.clone());
			
				ingredienteRetorno = entidade;
			} else {
				Ingrediente antigo = buscaInterna(entidade);
				antigo.setNome(entidade.getNome());
				ingredienteRetorno = antigo.clone();
			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return ingredienteRetorno;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Ingrediente buscaInterna(Ingrediente entidade) throws CadastroNaoEncontradoException {
		Optional<Ingrediente> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Ingrediente buscarPorId(Integer codigo) throws CadastroNaoEncontradoException {
		Optional<Ingrediente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Ingrediente> buscarTodos() {
		List<Ingrediente> novaLista = new ArrayList<>();
		for (Ingrediente entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return novaLista;
	}

}
