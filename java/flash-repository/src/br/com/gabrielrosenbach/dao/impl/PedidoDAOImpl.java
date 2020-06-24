package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.PedidoDAO;
import br.com.gabrielrosenbach.model.Pedido;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class PedidoDAOImpl implements PedidoDAO {

	private static List<Pedido> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Pedido salvar(Pedido entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			Pedido antigo = buscaInterna(entidade);
			antigo.setCliente(entidade.getCliente().clone());
			antigo.setDataPedido(entidade.getDataPedido());
			antigo.setProduto(entidade.getProduto().clone());
			antigo.setQuantidade(entidade.getQuantidade());
			antigo.setStatus(entidade.getStatus());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Pedido buscaInterna(Pedido entidade) {
		Optional<Pedido> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Pedido buscarPorId(Integer codigo) {
		Optional<Pedido> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Pedido> buscarTodos() throws CloneNotSupportedException {
		List<Pedido> novaLista = new ArrayList<>();

		for (Pedido entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}
}
