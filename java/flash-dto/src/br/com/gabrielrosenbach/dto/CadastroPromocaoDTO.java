package br.com.gabrielrosenbach.dto;

import java.util.Date;
import java.util.List;

import br.com.gabrielrosenbach.enumerator.TipoPromocaoEnum;
import br.com.gabrielrosenbach.util.DateUtil;

/**
 * 
 * @author Gabriel
 * DTO usado para o cadastro de promoção e no retorno ao salvar
 *
 */
public class CadastroPromocaoDTO extends GenericDTO {

	private String titulo;
	private String descricao;
	private Integer tipo;
	private Date dataValidade;
	private Boolean apenasPremium;
	private List<ProdutoDTO> produtos;
	private List<ClienteDTO> clientes;
	private DescontoDTO desconto;

	private List<Integer> codigoClientes;
	private List<Integer> codigoProdutos;

	public CadastroPromocaoDTO(Integer codigo, String titulo, String descricao, Integer tipo, Date dataValidade,
			Boolean apenasPremium, List<ProdutoDTO> produtos, List<ClienteDTO> clientes, DescontoDTO desconto,
			List<Integer> codigoClientes, List<Integer> codigoProdutos) {
		super(codigo);
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
		this.apenasPremium = apenasPremium;
		this.produtos = produtos;
		this.clientes = clientes;
		this.desconto = desconto;
		this.codigoClientes = codigoClientes;
		this.codigoProdutos = codigoProdutos;
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

	public List<Integer> getCodigoClientes() {
		return codigoClientes;
	}

	public void setCodigoClientes(List<Integer> codigoClientes) {
		this.codigoClientes = codigoClientes;
	}

	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}

	public DescontoDTO getDesconto() {
		return desconto;
	}

	public void setDesconto(DescontoDTO desconto) {
		this.desconto = desconto;
	}

	public List<Integer> getCodigoProdutos() {
		return codigoProdutos;
	}

	public void setCodigoProdutos(List<Integer> codigoProdutos) {
		this.codigoProdutos = codigoProdutos;
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Promoção: " + titulo + ", Descrição: " + descricao + ", Tipo: "
				+ TipoPromocaoEnum.get(tipo).getDescricao() + ", Data de Validade: "
				+ DateUtil.format(dataValidade, DateUtil.FORMATO_DD_MM_YYYY) + ", Apenas Premium: " + apenasPremium
				+ ",\n Produtos: " + produtos + ",\n Clientes: " + clientes + ",\n Desconto: " + desconto;
	}
}
