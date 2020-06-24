package br.com.gabrielrosenbach.test.cliente;

import java.util.Date;

import br.com.gabrielrosenbach.dto.ClienteDTO;
import br.com.gabrielrosenbach.dto.RetornoCepDTO;
import br.com.gabrielrosenbach.util.DateUtil;
import br.com.gabrielrosenbach.util.HttpRequest;

public class ClienteTest {
	
	public static void main(String[] args) {
		
		cadastrarCliente();
	}

	public static void cadastrarCliente() {
		Integer codigo = null;
		String nome = "Gabriel Rosenbach";
		String telefone = "99999-9999";
		Date dataNascimento = DateUtil.criarData(17, 11, 2000);
		String email = "email@teste.com";
		String senha = "123456";
		Boolean premium = Boolean.FALSE;
		
		String rua = "Sem rua";
		Integer numero = 0;
		Integer cep = 89940000;
		String bairro = "Linha Pessegueiro";
		
		RetornoCepDTO retorno = HttpRequest.buscarCep(cep);
		String cidade = retorno.getCidade();
		String estado = retorno.getEstado();
		
		ClienteDTO clienteDTO = new ClienteDTO(codigo, nome, telefone, dataNascimento, email, senha, premium, rua, numero, cidade, bairro, estado, cep);
		
		
	}
}

