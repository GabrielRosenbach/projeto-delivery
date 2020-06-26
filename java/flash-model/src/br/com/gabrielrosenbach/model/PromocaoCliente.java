package br.com.gabrielrosenbach.model;

public class PromocaoCliente extends GenericModel<PromocaoCliente> {
	
	private Promocao promocao;
	private Cliente cliente;

	public PromocaoCliente(Integer codigo, Promocao promocao, Cliente cliente) {
		super(codigo);
		this.promocao = promocao;
		this.cliente = cliente;
	}

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((promocao == null) ? 0 : promocao.hashCode());
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
		PromocaoCliente other = (PromocaoCliente) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (promocao == null) {
			if (other.promocao != null)
				return false;
		} else if (!promocao.equals(other.promocao))
			return false;
		return true;
	}
}
