package br.com.gabrielrosenbach.test.cliente;

import java.util.Date;

import br.com.gabrielrosenbach.bo.ClienteBO;
import br.com.gabrielrosenbach.bo.impl.ClienteBOImpl;
import br.com.gabrielrosenbach.dto.ClienteDTO;
import br.com.gabrielrosenbach.dto.LoginDTO;
import br.com.gabrielrosenbach.dto.RetornoCepDTO;
import br.com.gabrielrosenbach.util.DateUtil;
import br.com.gabrielrosenbach.util.HttpRequest;

public class ClienteTest {
	
	private static ClienteBO clienteBO = new ClienteBOImpl();
	
	public static void main(String[] args) {
		
		System.out.println("Cadastrando Cliente...");
		cadastrarCliente();
		System.out.println();
		
		System.out.println("Listando clientes...");
		listarCliente();
		System.out.println();
		
		System.out.println("Excluindo cliente...");
		excluirCliente();
		System.out.println();
		
		System.out.println("Listando clientes...");
		listarCliente();
		System.out.println();
		
		System.out.println("Editando Cliente...");
		editarCliente();
		System.out.println();
		
		System.out.println("Efetuando login...");
		efetuarLogin();
		System.out.println();
		
	}

	private static void efetuarLogin() {
		LoginDTO loginDTO = new LoginDTO("email@teste.com", "123456");
		System.out.println(clienteBO.verificarLogin(loginDTO));
	}

	private static void excluirCliente() {
		System.out.println(clienteBO.excluir(1));
	}

	private static void listarCliente() {
		clienteBO.buscarTodos().forEach(System.out::println);
	}

	public static void cadastrarCliente() {
		Integer codigo = null;
		String nome = "Gabriel Rosenbach";
		String telefone = "99999-9999";
		Date dataNascimento = DateUtil.criarData(17, 11, 2000);
		String email = "email@teste.com";
		String senha = "123456";
		Boolean premium = Boolean.FALSE;
		
		String rua = "Rua Santa Terrezinha";
		Integer numero = 0;
		Integer cep = 89940000;
		String bairro = "Linha Pessegueiro";
		
		RetornoCepDTO retorno = HttpRequest.buscarCep(cep);
		String cidade = retorno.getCidade();
		String estado = retorno.getEstado();
		
		ClienteDTO clienteDTO = new ClienteDTO(codigo, nome, telefone, dataNascimento, email, senha, premium, rua, numero, cidade, bairro, estado, cep);
		
		clienteDTO = clienteBO.salvar(clienteDTO);
		
		System.out.println(clienteDTO.toStringCliente());
		System.out.println(clienteDTO.toStringEndereco());
	}
	
	public static void editarCliente() {
		Integer codigo = 2;
		String nome = "Guilherme Rosenbach";
		String telefone = "99999-9999";
		Date dataNascimento = DateUtil.criarData(17, 11, 2000);
		String email = "email@teste.com";
		String senha = "123456";
		Boolean premium = Boolean.FALSE;
		
		String rua = "Rua Santa Terrezinha";
		Integer numero = 0;
		Integer cep = 89940000;
		String bairro = "Linha Pessegueiro";
		
		RetornoCepDTO retorno = HttpRequest.buscarCep(cep);
		String cidade = retorno.getCidade();
		String estado = retorno.getEstado();
		
		ClienteDTO clienteDTO = new ClienteDTO(codigo, nome, telefone, dataNascimento, email, senha, premium, rua, numero, cidade, bairro, estado, cep);
		
		clienteDTO = clienteBO.salvar(clienteDTO);
		
		System.out.println(clienteDTO.toStringCliente());
		System.out.println(clienteDTO.toStringEndereco());
	}
}

