package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gabrielrosenbach.dao.IngredienteDAO;
import br.com.gabrielrosenbach.dao.IngredienteProdutoDAO;
import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;
import br.com.gabrielrosenbach.model.Produto;

public class IngredienteProdutoDAOImpl implements IngredienteProdutoDAO {

	private static List<IngredienteProduto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	private static IngredienteDAO ingredienteDAO = new IngredienteDAOImpl();
	private static ProdutoDAO produtoDAO = new ProdutoDAOImpl();

	static {
		IngredienteProdutoDAO dao = new IngredienteProdutoDAOImpl();
		dao.salvar(1, Arrays.asList(1, 2, 4, 5));
	}

	@Override
	public List<IngredienteProduto> salvar(Integer codigoProduto, List<Integer> codigoIngredientes) {
		lista.removeIf(x -> x.getProduto().getCodigo().equals(codigoProduto));
		List<IngredienteProduto> listaRetorno = new ArrayList<>();
		try {
			Produto produto = produtoDAO.buscarPorId(codigoProduto);
			for (Integer codigo : codigoIngredientes) {

				Ingrediente ingrediente = ingredienteDAO.buscarPorId(codigo);
				IngredienteProduto ip = new IngredienteProduto(autoIncrement, ingrediente, produto);
				autoIncrement++;
				lista.add(ip.clone());
				listaRetorno.add(ip);

			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return listaRetorno;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	@Override
	public IngredienteProduto buscarPorId(Integer codigo) throws CadastroNaoEncontradoException {
		Optional<IngredienteProduto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<IngredienteProduto> buscarTodos() {
		List<IngredienteProduto> novaLista = new ArrayList<>();

		for (IngredienteProduto entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}

		return novaLista;
	}

	@Override
	public List<Ingrediente> buscarIngredientes(Integer codigoProduto) {
		List<Ingrediente> listaRetorno = new ArrayList<>();
		listaRetorno = buscarTodos().stream().filter(x -> x.getProduto().getCodigo().equals(codigoProduto))
				.map(IngredienteProduto::getIngrediente).collect(Collectors.toList());
		return listaRetorno;
	}
}
