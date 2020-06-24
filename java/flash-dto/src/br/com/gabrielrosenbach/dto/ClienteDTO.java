package br.com.gabrielrosenbach.dto;

import java.util.Date;

import br.com.gabrielrosenbach.util.DateUtil;

public class ClienteDTO extends GenericDTO {

	private String nome;
	private String telefone;
	private Date dataNascimento;
	private String identificacao;
	private String email;
	private String senha;
	private Boolean premium;

	private String rua;
	private Integer numero;
	private String cidade;
	private String bairro;
	private String estado;
	private Integer cep;

	public ClienteDTO(Integer codigo, String nome, String telefone, Date dataNascimento, String email, String senha, Boolean premium,
			String rua, Integer numero, String cidade, String bairro, String estado, Integer cep) {
		super(codigo);
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.premium = premium;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
	public String gerarIdentificacao() {
		String primeiroNome = nome.contains(" ") ? nome.substring(0, nome.indexOf(" ")) : nome;

		this.identificacao = primeiroNome + String.format("%2f", DateUtil.getDia(dataNascimento))
				+ String.format("%2f", DateUtil.getMes(dataNascimento));
		
		return this.identificacao;
	}
	
}
