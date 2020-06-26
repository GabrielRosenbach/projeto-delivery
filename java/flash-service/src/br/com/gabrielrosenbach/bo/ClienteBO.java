package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.ClienteDTO;
import br.com.gabrielrosenbach.dto.LoginDTO;
import br.com.gabrielrosenbach.dto.PesquisaDTO;

public interface ClienteBO {

	ClienteDTO salvar(ClienteDTO entidade);
	
	Boolean excluir(Integer codigo);
	
	ClienteDTO buscarPorId(Integer codigo);
	
	List<ClienteDTO> buscarTodos();
	
	Boolean verificarLogin(LoginDTO loginDTO);
	
	ClienteDTO buscarPorIdentificao(PesquisaDTO pesquisaDTO);
}
