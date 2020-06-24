package br.com.gabrielrosenbach.test.ingredienteproduto;

import java.util.Arrays;
import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteProdutoBO;
import br.com.gabrielrosenbach.bo.impl.IngredienteProdutoBOImpl;
import br.com.gabrielrosenbach.dto.IngredienteProdutoDTO;

public class IngredienteProdutoTest {

	public static void main(String[] args) {
		System.out.println("Listando ingredientes produtos...");
		buscarTodos();
		System.out.println();
		System.out.println("Cadastrando ingrediente...");
		cadastrar();
		System.out.println();
		System.out.println("Listando ingredientes...");
		buscarTodos();
	}

	public static void buscarTodos() {

		IngredienteProdutoBO ingredienteProdutoBO = new IngredienteProdutoBOImpl();

		List<IngredienteProdutoDTO> retorno = ingredienteProdutoBO.buscarTodos();
		retorno.forEach(System.out::println);

	}

	public static void cadastrar() {

		IngredienteProdutoBO ingredienteProdutoBO = new IngredienteProdutoBOImpl();
		
		List<IngredienteProdutoDTO> retorno = ingredienteProdutoBO.salvar(1, Arrays.asList(1, 2, 4));

		System.out.println(retorno);

	}

}
