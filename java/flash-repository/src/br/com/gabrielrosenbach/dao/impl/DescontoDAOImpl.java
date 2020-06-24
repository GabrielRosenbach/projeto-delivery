package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.DescontoDAO;
import br.com.gabrielrosenbach.model.Desconto;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class DescontoDAOImpl implements DescontoDAO {

	private static List<Desconto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Desconto salvar(Desconto entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			Desconto antigo = buscaInterna(entidade);
			antigo.setPromocao(entidade.getPromocao().clone());
			antigo.setTipo(entidade.getTipo());
			antigo.setValor(entidade.getValor());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Desconto buscaInterna(Desconto entidade) {
		Optional<Desconto> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Desconto buscarPorId(Integer codigo) {
		Optional<Desconto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Desconto> buscarTodos() throws CloneNotSupportedException {
		List<Desconto> novaLista = new ArrayList<>();
		for (Desconto entidade : lista) {
			novaLista.add(entidade.clone());
		}
		return novaLista;
	}

}
