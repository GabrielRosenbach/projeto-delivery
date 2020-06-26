package br.com.gabrielrosenbach.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gabrielrosenbach.dto.CadastroPromocaoDTO;
import br.com.gabrielrosenbach.dto.ClienteDTO;
import br.com.gabrielrosenbach.dto.DadosPromocaoDTO;
import br.com.gabrielrosenbach.dto.DescontoDTO;
import br.com.gabrielrosenbach.dto.IngredienteDTO;
import br.com.gabrielrosenbach.dto.IngredienteProdutoDTO;
import br.com.gabrielrosenbach.dto.PedidoDTO;
import br.com.gabrielrosenbach.dto.ProdutoDTO;
import br.com.gabrielrosenbach.dto.PromocaoDTO;
import br.com.gabrielrosenbach.model.Cliente;
import br.com.gabrielrosenbach.model.Desconto;
import br.com.gabrielrosenbach.model.Ingrediente;
import br.com.gabrielrosenbach.model.IngredienteProduto;
import br.com.gabrielrosenbach.model.Pedido;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.model.PromocaoCliente;
import br.com.gabrielrosenbach.model.PromocaoProduto;

public class DtoConverter {

	public static List<IngredienteDTO> IngredienteToIngredienteDTO(List<Ingrediente> models) {
		List<IngredienteDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> IngredienteToIngredienteDTO(x)).collect(Collectors.toList());
		return lista;
	}

	public static IngredienteDTO IngredienteToIngredienteDTO(Ingrediente model) {
		return new IngredienteDTO(model.getCodigo(), model.getNome());
	}

	public static List<IngredienteProdutoDTO> IngredienteProdutoToIngredienteProdutoDTO(
			List<IngredienteProduto> models) {
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
		return new ProdutoDTO(model.getCodigo(), model.getNome(), model.getPreco(), model.getPorcao(),
				model.getMedida(), model.getTipo(), null);
	}

	public static List<ClienteDTO> ClienteToClienteDTO(List<Cliente> models) {
		List<ClienteDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> ClienteToClienteDTO(x)).collect(Collectors.toList());
		return lista;
	}

	public static ClienteDTO ClienteToClienteDTO(Cliente model) {
		ClienteDTO clienteDTO = new ClienteDTO(model.getCodigo(), model.getNome(), model.getTelefone(),
				model.getDataNascimento(), model.getEmail(), Integer.toString(model.getSenha().hashCode()),
				model.getPremium(), model.getRua(), model.getNumero(), model.getCidade(), model.getBairro(),
				model.getEstado(), model.getCep());
		clienteDTO.setIdentificacao(model.getIdentificacao());
		return clienteDTO;
	}

	public static List<PedidoDTO> PedidoToPedidoDTO(List<Pedido> models) {
		List<PedidoDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> PedidoToPedidoDTO(x)).collect(Collectors.toList());
		return lista;
	}

	public static PedidoDTO PedidoToPedidoDTO(Pedido model) {
		PedidoDTO pedidoDTO = new PedidoDTO(model.getCodigo(), null, model.getDataPedido(), model.getCodigoProduto(),
				model.getQuantidade(), model.getStatus(), ProdutoToProdutoDTO(model.getProduto()));
		return pedidoDTO;
	}

	public static CadastroPromocaoDTO retornoCadastroPromocaoDTO(Promocao promocao, Desconto desconto,
			List<PromocaoCliente> promocaoClientes, List<PromocaoProduto> promocaoProdutos) {
		List<Cliente> clientes = promocaoClientes.stream().map(PromocaoCliente::getCliente)
				.collect(Collectors.toList());
		List<Produto> produtos = promocaoProdutos.stream().map(PromocaoProduto::getProduto)
				.collect(Collectors.toList());

		return new CadastroPromocaoDTO(promocao.getCodigo(), promocao.getTitulo(), promocao.getDescricao(),
				promocao.getTipo(), promocao.getDataValidade(), promocao.getApenasPremium(),
				ProdutoToProdutoDTO(produtos), ClienteToClienteDTO(clientes), descontoToDescontoDTO(desconto), null,
				null);
	}

	public static DescontoDTO descontoToDescontoDTO(Desconto desconto) {
		return new DescontoDTO(desconto.getCodigo(), desconto.getTipo(), desconto.getValor());
	}
	
	public static PromocaoDTO promocaoToPromocaoDTO(Promocao promocao) {
		return new PromocaoDTO(promocao.getCodigo(), promocao.getTitulo(), promocao.getDescricao(),
				promocao.getTipo(), promocao.getDataValidade(), promocao.getApenasPremium());
	}
	
	public static List<PromocaoDTO> promocaoToPromocaoDTO(List<Promocao> models) {
		List<PromocaoDTO> lista = new ArrayList<>();
		lista = models.stream().map(x -> promocaoToPromocaoDTO(x)).collect(Collectors.toList());
		return lista;
	}

	public static DadosPromocaoDTO gerarDadosPromocaoDTO(List<Produto> produtos, Desconto desconto) {
		return new DadosPromocaoDTO(ProdutoToProdutoDTO(produtos), descontoToDescontoDTO(desconto));
	}
}
