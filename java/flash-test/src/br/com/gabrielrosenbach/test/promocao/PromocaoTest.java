package br.com.gabrielrosenbach.test.promocao;

import java.util.Arrays;
import java.util.List;

import br.com.gabrielrosenbach.bo.PromocaoBO;
import br.com.gabrielrosenbach.bo.impl.PromocaoBOImpl;
import br.com.gabrielrosenbach.dto.CadastroPromocaoDTO;
import br.com.gabrielrosenbach.dto.DadosPromocaoDTO;
import br.com.gabrielrosenbach.dto.DescontoDTO;
import br.com.gabrielrosenbach.dto.PromocaoDTO;
import br.com.gabrielrosenbach.enumerator.TipoDescontoEnum;
import br.com.gabrielrosenbach.enumerator.TipoPromocaoEnum;
import br.com.gabrielrosenbach.util.DateUtil;

public class PromocaoTest {

	private static PromocaoBO promocaoBO = new PromocaoBOImpl();

	public static void main(String[] args) {
		System.out.println("Listando Promoções...");
		buscarTodos();
		System.out.println();
		
		System.out.println("Cadastrando Promoção...");
		cadastrar();
		System.out.println();
		
		System.out.println("Listando Promoções...");
		buscarTodos();
		System.out.println();
		
		System.out.println("Listando dados da promoção...");
		buscarDados();
		System.out.println();
		
		System.out.println("Excluindo produtos...");
		excluir();
		System.out.println();
		
		System.out.println("Listando produtos...");
		buscarTodos();
	}

	private static void buscarDados() {
		DadosPromocaoDTO dadosPromocaoDTO = promocaoBO.buscarDados(2);
		System.out.println(dadosPromocaoDTO);
	}

	public static void buscarTodos() {

		List<PromocaoDTO> retorno = promocaoBO.buscarTodos(1);
		retorno.forEach(System.out::println);
	}

	public static void cadastrar() {
		DescontoDTO descontoDTO = new DescontoDTO(null, TipoDescontoEnum.PRECO_FIXO.getValor(), 10.0);

		CadastroPromocaoDTO cadastroPromocaoDTO = new CadastroPromocaoDTO(null, "Desconto de R$10 reais em carnes",
				"Desconto de R$10 reais em carnes", TipoPromocaoEnum.DESCONTO_EM_PRODUTO.getValor(),
				DateUtil.criarData(07, 07, 2020), false, null, null, descontoDTO, Arrays.asList(1), Arrays.asList(1));

		cadastroPromocaoDTO = promocaoBO.salvar(cadastroPromocaoDTO);

		System.out.println(cadastroPromocaoDTO);

	}

	public static void excluir() {
		System.out.println(promocaoBO.excluir(1));
	}
}
