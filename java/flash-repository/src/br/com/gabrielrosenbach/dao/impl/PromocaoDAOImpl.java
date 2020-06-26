package br.com.gabrielrosenbach.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.enumerator.TipoPromocaoEnum;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.util.DateUtil;

public class PromocaoDAOImpl implements PromocaoDAO {

	private static List<Promocao> lista = new ArrayList<>();
	private static int autoIncrement = 1;

	static {
		PromocaoDAO dao = new PromocaoDAOImpl();
		
		Promocao promocao = new Promocao(null, "5% de desconto nos produtos selecionados",
				"5% de desconto em pratos japoneses", TipoPromocaoEnum.DESCONTO_EM_PRODUTO.getValor(),
				DateUtil.criarData(02, 06, 2020), false);
		
		dao.salvar(promocao);
	}

	@Override
	public Promocao salvar(Promocao entidade) {
		Promocao promocao = null;
		try {
			if (entidade.getCodigo() == null) {
				entidade.setCodigo(autoIncrement);
				autoIncrement++;
				lista.add(entidade.clone());
				promocao = entidade;
			} else {
				Promocao antigo = buscaInterna(entidade.getCodigo());
				antigo.setApenasPremium(entidade.getApenasPremium());
				antigo.setDataValidade(entidade.getDataValidade());
				antigo.setDescricao(entidade.getDescricao());
				antigo.setTipo(entidade.getTipo());
				antigo.setTitulo(entidade.getTitulo());
				promocao = antigo.clone();
			}
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return promocao;
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return lista.removeIf(x -> x.getCodigo().equals(codigo));
	}

	private Promocao buscaInterna(Integer codigo) {
		Promocao promocaoRetorno = null;
		try {
			Optional<Promocao> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				promocaoRetorno = optional.get();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return promocaoRetorno;
	}

	@Override
	public Promocao buscarPorId(Integer codigo) {
		Promocao promocaoRetorno = null;
		try {
			Optional<Promocao> optional = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
			if (optional.isPresent()) {
				promocaoRetorno = optional.get().clone();
			} else {
				throw new CadastroNaoEncontradoException();
			}
		} catch (CadastroNaoEncontradoException | CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return promocaoRetorno;
	}
}
