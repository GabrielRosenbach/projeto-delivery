package br.com.gabrielrosenbach.util;

public class CadastroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CadastroNaoEncontradoException() {
		super("Cadastro não encontrado!");
	}
}
