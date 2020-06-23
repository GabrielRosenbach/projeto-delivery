package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.util.CadastroNaoEncontradoException;

public class PromocaoDAOImpl implements PromocaoDAO {

	private static List<Promocao> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	@Override
	public Promocao salvar(Promocao entidade) throws CloneNotSupportedException, CadastroNaoEncontradoException {
		if (entidade.getCodigo() == null) {
			entidade.setCodigo(autoIncrement);
			autoIncrement++;
			lista.add(entidade.clone());
			return entidade;
		} else {
			Promocao antigo = buscaInterna(entidade);
			antigo.setApenasPremium(entidade.getApenasPremium());
			antigo.setDataValidade(entidade.getDataValidade());
			antigo.setDescricao(entidade.getDescricao());
			antigo.setTipo(entidade.getTipo());
			antigo.setTitulo(entidade.getTitulo());
			return antigo.clone();
		}
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Promocao buscaInterna(Promocao entidade) {
		Optional<Promocao> optional = lista.stream().filter(x -> x.equals(entidade)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public Promocao buscarPorId(Integer codigo) {
		Optional<Promocao> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CadastroNaoEncontradoException();
	}

	@Override
	public List<Promocao> buscarTodos() throws CloneNotSupportedException {
		List<Promocao> novaLista = new ArrayList<>();

		for (Promocao entidade : lista) {
			novaLista.add(entidade.clone());
		}

		return novaLista;
	}

}
