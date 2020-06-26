package br.com.gabrielrosenbach.bo.impl;

import java.util.List;

import br.com.gabrielrosenbach.bo.PedidoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.PedidoDAO;
import br.com.gabrielrosenbach.dao.exception.CadastroNaoEncontradoException;
import br.com.gabrielrosenbach.dao.exception.PedidoNaoEstaMaisEmEsperaException;
import br.com.gabrielrosenbach.dao.impl.PedidoDAOImpl;
import br.com.gabrielrosenbach.dto.PedidoDTO;
import br.com.gabrielrosenbach.model.Pedido;

public class PedidoBOImpl implements PedidoBO {

	PedidoDAO pedidoDAO = new PedidoDAOImpl();

	@Override
	public PedidoDTO salvar(PedidoDTO pedidoDTO) {

		Pedido pedido = new Pedido(null, null, null, pedidoDTO.getDataPedido(), pedidoDTO.getQuantidade(), null,
				pedidoDTO.getCodigoCliente(), pedidoDTO.getCodigoProduto());
		pedidoDAO.salvar(pedido);

		return DtoConverter.PedidoToPedidoDTO(pedido);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		Boolean retorno = Boolean.FALSE;
		try {
			retorno = pedidoDAO.excluir(codigo);
		} catch (PedidoNaoEstaMaisEmEsperaException e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

	@Override
	public PedidoDTO buscarPorId(Integer codigo) {
		PedidoDTO pedidoDTO = null;
		try {
			pedidoDTO = DtoConverter.PedidoToPedidoDTO(pedidoDAO.buscarPorId(codigo));
		} catch (CadastroNaoEncontradoException | CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		return pedidoDTO;
	}

	@Override
	public List<PedidoDTO> buscarTodos() {
		return DtoConverter.PedidoToPedidoDTO(pedidoDAO.buscarTodos());
	}

	@Override
	public Boolean alterarStatus(Integer codigoPedido, Integer codigoStatus) {
		Boolean retorno = Boolean.FALSE;
		try {
			retorno = pedidoDAO.alterarStatus(codigoPedido, codigoStatus);
		} catch (CadastroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	

}
