package br.com.gabrielrosenbach.dto;

import br.com.gabrielrosenbach.enumerator.TipoDescontoEnum;

public class DescontoDTO extends GenericDTO {

	private Integer tipo;
	private Double valor;

	public DescontoDTO(Integer codigo, Integer tipo, Double valor) {
		super(codigo);
		this.tipo = tipo;
		this.valor = valor;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		Boolean isPorcentagem = tipo.equals(TipoDescontoEnum.PORCENTAGEM.getValor());
		return "Desconto: " + (isPorcentagem ? "" : "R$") + valor + (isPorcentagem ? "%" : "");
	}
}
