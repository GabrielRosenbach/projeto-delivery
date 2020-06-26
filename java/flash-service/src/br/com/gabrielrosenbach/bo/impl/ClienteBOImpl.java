package br.com.gabrielrosenbach.bo.impl;

import java.util.List;

import br.com.gabrielrosenbach.bo.ClienteBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.ClienteDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.impl.ClienteDAOImpl;
import br.com.gabrielrosenbach.dto.ClienteDTO;
import br.com.gabrielrosenbach.dto.LoginDTO;
import br.com.gabrielrosenbach.dto.PesquisaDTO;
import br.com.gabrielrosenbach.model.Cliente;

public class ClienteBOImpl implements ClienteBO {

	private ClienteDAO clienteDAO = new ClienteDAOImpl();

	@Override
	public ClienteDTO salvar(ClienteDTO entidade) {
		Cliente cliente = new Cliente(entidade.getCodigo(), entidade.getNome(), entidade.getTelefone(),
				entidade.getDataNascimento(), entidade.getEmail(), entidade.getSenha(), entidade.getPremium(),
				entidade.getRua(), entidade.getNumero(), entidade.getCidade(), entidade.getBairro(),
				entidade.getEstado(), entidade.getCep());
		return DtoConverter.ClienteToClienteDTO(clienteDAO.salvar(cliente));
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return clienteDAO.excluir(codigo);
	}

	@Override
	public ClienteDTO buscarPorId(Integer codigo) {
		ClienteDTO clienteDTO = null;
		try {
			clienteDTO = DtoConverter.ClienteToClienteDTO(clienteDAO.buscarPorId(codigo));
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return clienteDTO;
	}

	@Override
	public List<ClienteDTO> buscarTodos() {
		return DtoConverter.ClienteToClienteDTO(clienteDAO.buscarTodos());
	}

	@Override
	public Boolean verificarLogin(LoginDTO loginDTO) {
		return clienteDAO.verificarLogin(loginDTO.getEmail(), loginDTO.getSenha());
	}

	@Override
	public ClienteDTO buscarPorIdentificao(PesquisaDTO pesquisaDTO) {
		ClienteDTO ClienteDTO = null;
		try {
			ClienteDTO = DtoConverter.ClienteToClienteDTO(clienteDAO.buscarPorIdentificao(pesquisaDTO.getPesquisa()));
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return ClienteDTO;
	}

}
