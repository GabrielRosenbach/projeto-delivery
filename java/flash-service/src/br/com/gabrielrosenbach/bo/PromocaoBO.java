package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.CadastroPromocaoDTO;
import br.com.gabrielrosenbach.dto.DadosPromocaoDTO;
import br.com.gabrielrosenbach.dto.PromocaoDTO;

public interface PromocaoBO {

	CadastroPromocaoDTO salvar(CadastroPromocaoDTO produtoDTO);
	
	Boolean excluir(Integer codigo);
	
	PromocaoDTO buscarPorId(Integer codigo);
	
	List<PromocaoDTO> buscarTodos(Integer codigoCliente);
	
	DadosPromocaoDTO buscarDados(Integer codigoPromocao);
}
