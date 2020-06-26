package br.com.gabrielrosenbach.bo;

import java.util.List;

import br.com.gabrielrosenbach.dto.PedidoDTO;

public interface PedidoBO {

	PedidoDTO salvar(PedidoDTO pedidoDTO);
	
	Boolean excluir(Integer codigo);
	
	PedidoDTO buscarPorId(Integer codigo);
	
	List<PedidoDTO> buscarTodos();
	
	Boolean alterarStatus(Integer codigoPedido, Integer codigoStatus);
}
