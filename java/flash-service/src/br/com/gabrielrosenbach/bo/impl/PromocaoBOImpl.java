package br.com.gabrielrosenbach.bo.impl;

import java.util.List;

import br.com.gabrielrosenbach.bo.PromocaoBO;
import br.com.gabrielrosenbach.converter.DtoConverter;
import br.com.gabrielrosenbach.dao.DescontoDAO;
import br.com.gabrielrosenbach.dao.PromocaoClienteDAO;
import br.com.gabrielrosenbach.dao.PromocaoDAO;
import br.com.gabrielrosenbach.dao.PromocaoProdutoDAO;
import br.com.gabrielrosenbach.dao.impl.DescontoDAOImpl;
import br.com.gabrielrosenbach.dao.impl.PromocaoClienteDAOImpl;
import br.com.gabrielrosenbach.dao.impl.PromocaoDAOImpl;
import br.com.gabrielrosenbach.dao.impl.PromocaoProdutoDAOImpl;
import br.com.gabrielrosenbach.dto.CadastroPromocaoDTO;
import br.com.gabrielrosenbach.dto.DadosPromocaoDTO;
import br.com.gabrielrosenbach.dto.DescontoDTO;
import br.com.gabrielrosenbach.dto.PromocaoDTO;
import br.com.gabrielrosenbach.model.Desconto;
import br.com.gabrielrosenbach.model.Produto;
import br.com.gabrielrosenbach.model.Promocao;
import br.com.gabrielrosenbach.model.PromocaoCliente;
import br.com.gabrielrosenbach.model.PromocaoProduto;

public class PromocaoBOImpl implements PromocaoBO {

	public PromocaoDAO promocaoDAO = new PromocaoDAOImpl();
	public PromocaoProdutoDAO promocaoProdutoDAO = new PromocaoProdutoDAOImpl();
	public PromocaoClienteDAO promocaoClienteDAO = new PromocaoClienteDAOImpl();
	public DescontoDAO descontoDAO = new DescontoDAOImpl();

	@Override
	public CadastroPromocaoDTO salvar(CadastroPromocaoDTO promocaoDTO) {
		Promocao promocao = new Promocao(promocaoDTO.getCodigo(), promocaoDTO.getTitulo(), promocaoDTO.getDescricao(), promocaoDTO.getTipo(), promocaoDTO.getDataValidade(), promocaoDTO.getApenasPremium());
		promocao = promocaoDAO.salvar(promocao);
		
		DescontoDTO descontoDTO = promocaoDTO.getDesconto();
		
		Desconto desconto = new Desconto(descontoDTO.getCodigo(), null, descontoDTO.getTipo(), descontoDTO.getValor(), promocao.getCodigo());
		
		desconto = descontoDAO.salvar(desconto);
		
		List<PromocaoProduto> promocaoProdutos = promocaoProdutoDAO.salvar(promocao.getCodigo(), promocaoDTO.getCodigoProdutos());
		List<PromocaoCliente> promocaoClientes = promocaoClienteDAO.salvar(promocao.getCodigo(), promocaoDTO.getCodigoClientes());
		
		return DtoConverter.retornoCadastroPromocaoDTO(promocao, desconto, promocaoClientes, promocaoProdutos);
	}

	@Override
	public Boolean excluir(Integer codigo) {
		return promocaoDAO.excluir(codigo);
	}

	@Override
	public PromocaoDTO buscarPorId(Integer codigo) {
		return DtoConverter.promocaoToPromocaoDTO(promocaoDAO.buscarPorId(codigo));
	}

	@Override
	public List<PromocaoDTO> buscarTodos(Integer codigoCliente) {
		return DtoConverter.promocaoToPromocaoDTO(promocaoClienteDAO.buscarPromocoes(codigoCliente));
	}

	@Override
	public DadosPromocaoDTO buscarDados(Integer codigoPromocao) {
		List<Produto> produtos = promocaoProdutoDAO.buscarProdutos(codigoPromocao);
		Desconto desconto = descontoDAO.buscarPorPromocao(codigoPromocao);
		return DtoConverter.gerarDadosPromocaoDTO(produtos, desconto);
	}

}
