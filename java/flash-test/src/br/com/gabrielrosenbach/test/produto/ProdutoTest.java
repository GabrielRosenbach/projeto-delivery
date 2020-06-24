package br.com.gabrielrosenbach.test.produto;

import java.util.Arrays;
import java.util.List;

import br.com.gabrielrosenbach.bo.ProdutoBO;
import br.com.gabrielrosenbach.bo.impl.ProdutoBOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.ProdutoDTO;
import br.com.gabrielrosenbach.enumerator.TipoProdutoEnum;

public class ProdutoTest {

	public static void main(String[] args) {
		System.out.println("Listando produtos...");
		buscarTodos();
		System.out.println();
		System.out.println("Listando ingredientes do produto...");
		buscarIngredientes(1);
		System.out.println();
		System.out.println("Cadastrando produtos...");
		cadastrar();
		System.out.println();
		System.out.println("Listando ingredientes do produto...");
		buscarIngredientes(2);
		System.out.println();
		System.out.println("Listando produtos...");
		buscarTodos();
		System.out.println();
		System.out.println("Excluindo produtos...");
		excluir();
		System.out.println();
		System.out.println("Listando produtos...");
		buscarTodos();
	}

	public static void buscarTodos() {

		ProdutoBO produtoBO = new ProdutoBOImpl();

		List<ProdutoDTO> retorno = produtoBO.buscarTodos();
		retorno.forEach(System.out::println);
	}
	
	public static void buscarIngredientes(Integer codigoProduto) {
		
		ProdutoBO produtoBO = new ProdutoBOImpl();

		List<IngredienteDTO> retorno = produtoBO.buscarIngredientes(codigoProduto);
		
		retorno.forEach(System.out::println);
	}

	public static void cadastrar() {

		ProdutoBO produtoBO = new ProdutoBOImpl();

		ProdutoDTO produtoDTO = new ProdutoDTO(null, "Ketchup", 5.00, 10, 200.00, TipoProdutoEnum.CONDIMENTO.getValor(), Arrays.asList(3));

		produtoDTO = produtoBO.salvar(produtoDTO);

		System.out.println(produtoDTO);

	}
	
	public static void excluir() {

		ProdutoBO produtoBO = new ProdutoBOImpl();

		produtoBO.excluir(1);
	}
}
