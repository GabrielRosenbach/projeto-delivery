package br.com.gabrielrosenbach.dto;

import java.util.Date;

import br.com.gabrielrosenbach.enumerator.TipoPromocaoEnum;
import br.com.gabrielrosenbach.util.DateUtil;

public class PromocaoDTO extends GenericDTO {

	private String titulo;
	private String descricao;
	private Integer tipo;
	private Date dataValidade;
	private Boolean apenasPremium;

	public PromocaoDTO(Integer codigo, String titulo, String descricao, Integer tipo, Date dataValidade,
			Boolean apenasPremium) {
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
	public String toString() {
		return "Promoção: " + titulo + ", Descrição: " + descricao + ", Tipo: "
				+ TipoPromocaoEnum.get(tipo).getDescricao() + ", Data de Validade: "
				+ DateUtil.format(dataValidade, DateUtil.FORMATO_DD_MM_YYYY) + ", Apenas Premium: " + apenasPremium;
	}
}
