package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.ClienteDAO;
import br.com.gabrielrosenbach.model.Cliente;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class ClienteDAOImpl implements ClienteDAO {

	private static List<Cliente> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Cliente salvar(Cliente entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
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
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Cliente buscaInterna(Cliente entidade) {
		Optional<Cliente> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Cliente buscarPorId(Integer codigo) {
		Optional<Cliente> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Cliente> buscarTodos() throws CloneNotSupportedException {
		List<Cliente> novaLista = new ArrayList<>();

		for (Cliente entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
