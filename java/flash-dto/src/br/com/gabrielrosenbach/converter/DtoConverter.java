package br.com.gabrielrosenbach.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.IngredienteProdutoDTO;
import br.com.gabrielrosenbach.dto.ProdutoDTO;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;
import br.com.gabrielrosenbach.model.Produto;

public class DtoConverter {
	
	public static List<IngredienteDTO> IngredienteToIngredienteDTO(List<Ingrediente> models) {
		List<IngredienteDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> IngredienteToIngredienteDTO(x)).collect(Collectors.toList());
		return lista;
	}
	
	public static IngredienteDTO IngredienteToIngredienteDTO(Ingrediente model) {
		return new IngredienteDTO(model.getCodigo(), model.getNome());
	}
	
	public static List<IngredienteProdutoDTO> IngredienteProdutoToIngredienteProdutoDTO(List<IngredienteProduto> models) {
		List<IngredienteProdutoDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> IngredienteProdutoToIngredienteProdutoDTO(x)).collect(Collectors.toList());
		return lista;
	}
	
	public static IngredienteProdutoDTO IngredienteProdutoToIngredienteProdutoDTO(IngredienteProduto model) {
		return new IngredienteProdutoDTO(model.getCodigo(), IngredienteToIngredienteDTO(model.getIngrediente()));
	}
	
	public static List<ProdutoDTO> ProdutoToProdutoDTO(List<Produto> models) {
		List<ProdutoDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> ProdutoToProdutoDTO(x)).collect(Collectors.toList());
		return lista;
	}
	
	public static ProdutoDTO ProdutoToProdutoDTO(Produto model) {
		return new ProdutoDTO(model.getCodigo(), model.getNome(), model.getPreco(), model.getPorcao(), model.getMedida(), model.getTipo(), null);
	}
	
	
	

}
