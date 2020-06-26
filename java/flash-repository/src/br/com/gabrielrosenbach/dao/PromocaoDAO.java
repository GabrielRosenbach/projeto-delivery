package br.com.gabrielrosenbach.dao;

import java.util.List;

import br.com.gabrielrosenbach.model.Promocao;

public interface PromocaoDAO {

	Promocao salvar(Promocao entidade);

	Boolean excluir(Integer codigo);

	Promocao buscarPorId(Integer codigo);
}
