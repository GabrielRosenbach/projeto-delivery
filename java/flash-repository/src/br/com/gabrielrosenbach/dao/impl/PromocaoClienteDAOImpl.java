package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gabrielrosenbach.dao.ClienteDAO;
import br.com.gabrielrosenbach.dao.PromocaoClienteDAO;
import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.model.Cliente;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.model.PromocaoCliente;

public class PromocaoClienteDAOImpl implements PromocaoClienteDAO {

	private static List<PromocaoCliente> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	private static ClienteDAO clienteDAO = new ClienteDAOImpl();
	private static PromocaoDAO promocaoDAO = new PromocaoDAOImpl();
	
	static {
		PromocaoClienteDAO dao = new PromocaoClienteDAOImpl();
		dao.salvar(1, Arrays.asList(1));
	}

	@Override
	public List<PromocaoCliente> salvar(Integer codigoPromocao, List<Integer> codigoClientes) {
		lista.removeIf(x -> x.getPromocao().getCodigo().equals(codigoPromocao));
		List<PromocaoCliente> listaRetorno = new ArrayList<>();
		try {
			Promocao promocao = promocaoDAO.buscarPorId(codigoPromocao);

			for (Integer codigo : codigoClientes) {

				Cliente cliente = clienteDAO.buscarPorId(codigo);
				PromocaoCliente pc = new PromocaoCliente(autoIncrement, promocao, cliente);
				autoIncrement++;
				lista.add(pc.clone());
				listaRetorno.add(pc);

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
	public PromocaoCliente buscarPorId(Integer codigo) {
		PromocaoCliente retornoPromocaoCliente = null;
		try {
			Optional<PromocaoCliente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				retornoPromocaoCliente = optional.get().clone();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return retornoPromocaoCliente;
	}

	@Override
	public List<PromocaoCliente> buscarTodos() {
		List<PromocaoCliente> novaLista = new ArrayList<>();
		for (PromocaoCliente entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return novaLista;
	}

	@Override
	public List<Promocao> buscarPromocoes(Integer codigoCliente) {
		List<Promocao> retorno = new ArrayList<>();
		List<Promocao> promocoes = lista.stream().filter(x -> x.getCliente().getCodigo().equals(codigoCliente))
				.map(PromocaoCliente::getPromocao).collect(Collectors.toList());
		for (Promocao entidade : promocoes) {
			try {
				retorno.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return retorno;
	}
}
