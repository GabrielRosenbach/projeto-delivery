package br.com.gabrielrosenbach.test.pedido;

import java.util.Date;

import br.com.gabrielrosenbach.bo.PedidoBO;
import br.com.gabrielrosenbach.bo.impl.PedidoBOImpl;
import br.com.gabrielrosenbach.dto.PedidoDTO;

public class PedidoTest {
	
	private static PedidoBO pedidoBO = new PedidoBOImpl();
	
	public static void main(String[] args) {
		
		System.out.println("Cadastrando Pedido...");
		cadastrarPedido();
		System.out.println();
		
		System.out.println("Listando Pedido...");
		listarPedido();
		System.out.println();
		
		System.out.println("Excluindo Pedido...");
		excluirPedido(1);
		System.out.println();
		
		System.out.println("Listando Pedido...");
		listarPedido();
		System.out.println();
		
		System.out.println("Alterando Status...");
		alterarStatus();
		System.out.println();
		
		System.out.println("Listando Pedido...");
		listarPedido();
		System.out.println();
		
		System.out.println("Excluindo Pedido...");
		excluirPedido(2);
		System.out.println();
	}

	private static void excluirPedido(Integer codigo) {
		System.out.println(pedidoBO.excluir(codigo));
	}

	private static void listarPedido() {
		pedidoBO.buscarTodos().forEach(System.out::println);
	}

	public static void cadastrarPedido() {
		PedidoDTO pedidoDTO = new PedidoDTO(null, 1, new Date(), 1, 2, null, null);
		System.out.println(pedidoBO.salvar(pedidoDTO));
	}
	
	private static void alterarStatus() {
		System.out.println(pedidoBO.alterarStatus(2, 2));
	}
}

