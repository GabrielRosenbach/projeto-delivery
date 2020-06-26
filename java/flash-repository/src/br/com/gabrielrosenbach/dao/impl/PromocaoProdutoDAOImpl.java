package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.dao.PromocaoProdutoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.model.PromocaoProduto;

public class PromocaoProdutoDAOImpl implements PromocaoProdutoDAO {

	private static List<PromocaoProduto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	private static ProdutoDAO produtoDAO = new ProdutoDAOImpl();
	private static PromocaoDAO promocaoDAO = new PromocaoDAOImpl();
	
	static {
		PromocaoProdutoDAO dao = new PromocaoProdutoDAOImpl();
		dao.salvar(1, Arrays.asList(1));
	}

	@Override
	public List<PromocaoProduto> salvar(Integer codigoPromocao, List<Integer> codigoProdutos) {
		lista.removeIf(x -> x.getPromocao().getCodigo().equals(codigoPromocao));
		List<PromocaoProduto> listaRetorno = new ArrayList<>();
		try {
			Promocao promocao = promocaoDAO.buscarPorId(codigoPromocao);

			for (Integer codigo : codigoProdutos) {

				Produto produto = produtoDAO.buscarPorId(codigo);
				PromocaoProduto pp = new PromocaoProduto(autoIncrement, promocao, produto);
				autoIncrement++;
				lista.add(pp.clone());
				listaRetorno.add(pp);

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
	public PromocaoProduto buscarPorId(Integer codigo) {
		PromocaoProduto retornoPromocaoProduto = null;
		try {
			Optional<PromocaoProduto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				retornoPromocaoProduto = optional.get().clone();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return retornoPromocaoProduto;
	}

	@Override
	public List<PromocaoProduto> buscarTodos() {
		List<PromocaoProduto> novaLista = new ArrayList<>();
		for (PromocaoProduto entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return novaLista;
	}

	@Override
	public List<Produto> buscarProdutos(Integer codigoPromocao) {
		List<Produto> retorno = new ArrayList<>();
		List<Produto> produtos = lista.stream().filter(x -> x.getPromocao().getCodigo().equals(codigoPromocao))
				.map(PromocaoProduto::getProduto).collect(Collectors.toList());
		for (Produto entidade : produtos) {
			try {
				retorno.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return retorno;
	}

}
