package br.com.gabrielrosenbach.model;

public abstract class GenericModel<T> implements Cloneable {

	private Integer codigo;
	
	public GenericModel(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		if (this.codigo == null) {
			this.codigo = codigo;
		}
	}
	
	public T clone() throws CloneNotSupportedException {
		return (T) super.clone();
	}
	
}
