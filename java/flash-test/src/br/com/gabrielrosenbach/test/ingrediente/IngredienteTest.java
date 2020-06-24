package br.com.gabrielrosenbach.test.ingrediente;

import java.util.List;

import br.com.gabrielrosenbach.bo.IngredienteBO;
import br.com.gabrielrosenbach.bo.impl.IngredienteBOImpl;
import br.com.gabrielrosenbach.dto.IngredienteDTO;

public class IngredienteTest {

	public static void main(String[] args) {
		System.out.println("Listando ingredientes...");
		buscarTodos();
		System.out.println();
		System.out.println("Cadastrando ingrediente...");
		cadastrar();
		System.out.println();
		System.out.println("Excluindo ingrediente...");
		excluir();
		System.out.println();
		System.out.println("Listando ingredientes...");
		buscarTodos();
	}

	public static void buscarTodos() {

		IngredienteBO ingredienteBO = new IngredienteBOImpl();

		List<IngredienteDTO> retorno = ingredienteBO.buscarTodos();
		retorno.forEach(System.out::println);

	}

	public static void cadastrar() {

		IngredienteBO ingredienteBO = new IngredienteBOImpl();

		Integer codigo = null;
		String nome = "Milho";

		IngredienteDTO ingredienteDTO = new IngredienteDTO(codigo, nome);

		ingredienteDTO = ingredienteBO.salvar(ingredienteDTO);

		System.out.println(ingredienteDTO);

	}
	
	public static void excluir() {

		IngredienteBO ingredienteBO = new IngredienteBOImpl();

		ingredienteBO.excluir(8);
	}
}
