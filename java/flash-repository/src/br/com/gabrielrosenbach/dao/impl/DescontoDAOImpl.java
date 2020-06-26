package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.DescontoDAO;
import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.enumerator.TipoDescontoEnum;
import br.com.gabrielrosenbach.model.Desconto;
import br.com.gabrielrosenbach.model.Promocao;

public class DescontoDAOImpl implements DescontoDAO {

	private static List<Desconto> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	private static PromocaoDAO promocaoDAO = new PromocaoDAOImpl();
	
	static {
		DescontoDAO DescontoDAO = new DescontoDAOImpl();
		
		Desconto desconto = new Desconto(null, null, TipoDescontoEnum.PORCENTAGEM.getValor(), 5.0, 1);
		DescontoDAO.salvar(desconto);
	}

	@Override
	public Desconto salvar(Desconto entidade) {
		Desconto descontoRetorno = null;
		try {
			Promocao promocao = promocaoDAO.buscarPorId(entidade.getCodigoPromocao());
			if (entidade.getCodigo() == null) {
				entidade.setPromocao(promocao);
				entidade.setCodigo(autoIncrement);
				autoIncrement++;
				lista.add(entidade.clone());
				descontoRetorno = entidade;
			} else {
				Desconto antigo = buscaInterna(entidade.getCodigo());
				antigo.setPromocao(promocao);
				antigo.setTipo(entidade.getTipo());
				antigo.setValor(entidade.getValor());
				antigo.setCodigoPromocao(entidade.getCodigoPromocao());
				descontoRetorno = antigo.clone();
			}
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return descontoRetorno;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Desconto buscaInterna(Integer codigo) {
		Desconto descontoRetorno = null;
		try {
			Optional<Desconto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				descontoRetorno = optional.get();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return descontoRetorno;
	}

	@Override
	public Desconto buscarPorId(Integer codigo) {
		Desconto descontoRetorno = null;
		try {
			Optional<Desconto> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				descontoRetorno = optional.get().clone();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return descontoRetorno;
	}

	@Override
	public List<Desconto> buscarTodos() {
		List<Desconto> novaLista = new ArrayList<>();
		for (Desconto entidade : lista) {
			try {
				novaLista.add(entidade.clone());
			} catch (CloneNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
		return novaLista;
	}

	@Override
	public Desconto buscarPorPromocao(Integer codigoPromocao) {
		Desconto descontoRetorno = null;
		try {
			Optional<Desconto> optional = lista.stream().filter(x -> x.getPromocao().getCodigo().equals(codigoPromocao)).findFirst();
			if (optional.isPresent()) {
				descontoRetorno = optional.get().clone();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CloneNotSupportedException | CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return descontoRetorno;
	}

}
