package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.ClienteDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.exception.LoginJaExisteException;
import br.com.gabrielrosenbach.model.Cliente;
import br.com.gabrielrosenbach.util.DateUtil;

public class ClienteDAOImpl implements ClienteDAO {

	private static List<Cliente> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	static {
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		Cliente cliente = new Cliente(null, "João Pedro", "11111-1111", DateUtil.criarData(15, 10, 2001), "teste@teste.com",
				"789654", false, "Rua Marechal", 74, "Rio de Janeiro", "Ipanema", "RJ", 12121212);
		clienteDAO.salvar(cliente);
	}

	@Override
	public Cliente salvar(Cliente entidade) {
		Cliente clienteRetorno = null;
		try {
			if (entidade.getCodigo() == null) {
				Boolean verificaLogin = verificarLogin(entidade.getEmail(), entidade.getSenha());
				if (verificaLogin) {
					throw new LoginJaExisteException();
				}
				entidade.setCodigo(autoIncrement);
				autoIncrement++;
				lista.add(entidade.clone());
				clienteRetorno = entidade;
			} else {
				Cliente antigo = buscaInterna(entidade);
				antigo.setDataNascimento(entidade.getDataNascimento());
				antigo.setEmail(entidade.getEmail());
				antigo.setNome(entidade.getNome());
				antigo.setPremium(entidade.getPremium());
				antigo.setSenha(entidade.getSenha());
				antigo.setTelefone(entidade.getTelefone());

				antigo.setBairro(entidade.getBairro());
				antigo.setCep(entidade.getCep());
				antigo.setCidade(entidade.getCidade());
				antigo.setEstado(entidade.getEstado());
				antigo.setNumero(entidade.getNumero());
				antigo.setRua(entidade.getRua());
				antigo.gerarIdentificacao();
				clienteRetorno = antigo.clone();
			}
		} catch (CloneNotSupportedException | LoginJaExisteException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return clienteRetorno;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Cliente buscaInterna(Cliente entidade) throws CadastroNaoEncontradoException {
		Optional<Cliente> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Cliente buscarPorId(Integer codigo) throws CadastroNaoEncontradoException {
		Optional<Cliente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> novaLista = new ArrayList<>();

		for (Cliente entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}

		return novaLista;
	}

	@Override
	public Boolean verificarLogin(String email, String senha) {
		return lista.stream().filter(x -> x.getEmail().toUpperCase().equals(email.toUpperCase())
				&& x.getSenha().toUpperCase().equals(senha.toUpperCase())).count() > 0;
	}

	@Override
	public Cliente buscarPorIdentificao(String pesquisa) throws CadastroNaoEncontradoException {
		Optional<Cliente> optional = lista.stream().filter(x -> x.getIdentificacao().equals(pesquisa.toLowerCase()))
				.findFirst();
		if (optional.isPresent()) {
			try {
				return optional.get().clone();
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		throw new CadastroNaoEncontradoException();
	}

}
