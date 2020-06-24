package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.enumerator.TipoProdutoEnum;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class ProdutoDAOImpl implements ProdutoDAO {

	private static List<Produto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	static {
		ProdutoDAO dao = new ProdutoDAOImpl();
		dao.salvar(new Produto("Bife", 20.00, 2, 600.00, TipoProdutoEnum.PRATO.getValor()));
	}

	@Override
	public Produto salvar(Produto entidade) {
		Produto ProdutoRetorno = null;
		try {
			if (entidade.getCodigo() == null) {
				entidade.setCodigo(autoIncrement);
				autoIncrement++;

				lista.add(entidade.clone());

				ProdutoRetorno = entidade;
			} else {
				Produto antigo = buscaInterna(entidade);
				antigo.setMedida(entidade.getMedida());
				antigo.setNome(entidade.getNome());
				antigo.setPreco(entidade.getPreco());
				antigo.setTipo(entidade.getTipo());
				ProdutoRetorno = antigo.clone();
			}
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}

		return ProdutoRetorno;
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
	public List<Produto> buscarTodos() {
		List<Produto> novaLista = new ArrayList<>();

		for (Produto entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return novaLista;
	}
}
