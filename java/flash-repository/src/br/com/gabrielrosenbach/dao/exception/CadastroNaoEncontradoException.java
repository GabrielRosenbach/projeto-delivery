package br.com.gabrielrosenbach.dao.exception;

public class CadastroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public CadastroNaoEncontradoException() {
		super("Cadastro não encontrado!");
	}
}
