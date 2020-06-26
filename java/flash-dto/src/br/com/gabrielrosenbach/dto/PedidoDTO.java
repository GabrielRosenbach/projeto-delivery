package br.com.gabrielrosenbach.dto;

import java.util.Date;

import br.com.gabrielrosenbach.enumerator.TipoStatusPedidoEnum;
import br.com.gabrielrosenbach.util.DateUtil;

public class PedidoDTO extends GenericDTO {

	private Integer codigoCliente;
	private Date dataPedido;
	private Integer codigoProduto;
	private Integer quantidade;
	private Integer status;
	private Double precoTotal;

	private ProdutoDTO produto;

	public PedidoDTO(Integer codigo, Integer codigoCliente, Date dataPedido, Integer codigoProduto, Integer quantidade,
			Integer status, ProdutoDTO produto) {
		super(codigo);
		this.codigoCliente = codigoCliente;
		this.dataPedido = dataPedido;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.status = status;
		this.produto = produto;
		gerarPrecoTotal();
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		gerarPrecoTotal();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
		gerarPrecoTotal();
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	private void gerarPrecoTotal() {
		if (produto != null) {
			this.precoTotal = produto.getPreco() * quantidade;
		}
	}

	@Override
	public String toString() {
		return "Pedido: " + getCodigo() + ", Produto: " + produto.getNome() + ", Data do Pedido: "
				+ DateUtil.format(dataPedido, DateUtil.FORMATO_DD_MM_YYYY) + ", Preço do Produto: R$" + produto.getPreco() + ", Quantidade: " + quantidade
				+ ", Total: R$" + precoTotal + ", Status: "
				+ TipoStatusPedidoEnum.get(status).getDescricao();
	}

}
