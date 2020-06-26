package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.ClienteDAO;
import br.com.gabrielrosenbach.dao.PedidoDAO;
import br.com.gabrielrosenbach.dao.ProdutoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.exception.PedidoNaoEstaMaisEmEsperaException;
import br.com.gabrielrosenbach.enumerator.TipoStatusPedidoEnum;
import br.com.gabrielrosenbach.model.Cliente;
import br.com.gabrielrosenbach.model.Pedido;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.util.DateUtil;

public class PedidoDAOImpl implements PedidoDAO {

	private static List<Pedido> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	private static ClienteDAO clienteDAO = new ClienteDAOImpl();
	private static ProdutoDAO produtoDAO = new ProdutoDAOImpl();

	static {
		PedidoDAO dao = new PedidoDAOImpl();

		Pedido pedido = new Pedido(null, null, null, DateUtil.criarData(12, 06, 2020), 2, null, 1, 1);
		dao.salvar(pedido);
	}

	@Override
	public Pedido salvar(Pedido pedido) {
		Pedido pedidoRetorno = null;
		try {
			Cliente cliente = clienteDAO.buscarPorId(pedido.getCodigoCliente());
			Produto produto = produtoDAO.buscarPorId(pedido.getCodigoProduto());

			if (pedido.getCodigo() == null) {
				pedido.setCliente(cliente);
				pedido.setProduto(produto);
				pedido.setStatus(TipoStatusPedidoEnum.EM_ESPERA.getValor());
				pedido.setCodigo(autoIncrement);
				autoIncrement++;
				lista.add(pedido.clone());
				pedidoRetorno = pedido;
			} else if (!pedido.getStatus().equals(TipoStatusPedidoEnum.EM_ESPERA.getValor())) {
				throw new PedidoNaoEstaMaisEmEsperaException();
			} else {
				Pedido entidade = buscaInterna(pedido.getCodigo());
				entidade.setCodigoProduto(pedido.getCodigoProduto());
				entidade.setProduto(produto);
				entidade.setQuantidade(pedido.getQuantidade());
				pedidoRetorno = entidade.clone();
			}

		} catch (CloneNotSupportedException | PedidoNaoEstaMaisEmEsperaException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return pedidoRetorno;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		try {
			Pedido pedido = buscarPorId(codigo);
			if (!pedido.getStatus().equals(TipoStatusPedidoEnum.EM_ESPERA.getValor())) {
				throw new PedidoNaoEstaMaisEmEsperaException();
			}
		} catch (CadastroNaoEncontradoException | PedidoNaoEstaMaisEmEsperaException | CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Pedido buscaInterna(Integer codigo) throws CadastroNaoEncontradoException {
		Optional<Pedido> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Pedido buscarPorId(Integer codigo) throws CadastroNaoEncontradoException, CloneNotSupportedException {
		Optional<Pedido> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get().clone();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Pedido> buscarTodos() {
		List<Pedido> novaLista = new ArrayList<>();

		for (Pedido entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}

		return novaLista;
	}

	@Override
	public Boolean alterarStatus(Integer codigoPedido, Integer codigoStatus) throws CadastroNaoEncontradoException {
		Pedido pedido = buscaInterna(codigoPedido);
		pedido.setStatus(codigoStatus);
		return Boolean.TRUE;
	}
}
