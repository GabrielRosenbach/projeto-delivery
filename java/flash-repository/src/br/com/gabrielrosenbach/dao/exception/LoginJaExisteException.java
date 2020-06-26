package br.com.gabrielrosenbach.dao.exception;

public class LoginJaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginJaExisteException() {
		super("Está combinação de email e senha já existe!");
	}
}
