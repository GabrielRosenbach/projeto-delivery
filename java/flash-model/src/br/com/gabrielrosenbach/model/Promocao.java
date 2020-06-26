package br.com.gabrielrosenbach.model;

import java.util.Date;

public class Promocao extends GenericModel<Promocao> {

	private String titulo;
	private String descricao;
	private Integer tipo;
	private Date dataValidade;
	private Boolean apenasPremium;
	
	public Promocao(Integer codigo, String titulo, String descricao, Integer tipo, Date dataValidade, Boolean apenasPremium) {
		super(codigo);
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
		this.apenasPremium = apenasPremium;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Boolean getApenasPremium() {
		return apenasPremium;
	}

	public void setApenasPremium(Boolean apenasPremium) {
		this.apenasPremium = apenasPremium;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apenasPremium == null) ? 0 : apenasPremium.hashCode());
		result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocao other = (Promocao) obj;
		if (apenasPremium == null) {
			if (other.apenasPremium != null)
				return false;
		} else if (!apenasPremium.equals(other.apenasPremium))
			return false;
		if (dataValidade == null) {
			if (other.dataValidade != null)
				return false;
		} else if (!dataValidade.equals(other.dataValidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
