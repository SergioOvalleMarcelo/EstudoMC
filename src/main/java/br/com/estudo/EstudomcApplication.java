package br.com.estudo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo.domain.Categoria;
import br.com.estudo.domain.Cidade;
import br.com.estudo.domain.Cliente;
import br.com.estudo.domain.Endereco;
import br.com.estudo.domain.Estado;
import br.com.estudo.domain.Pagamento;
import br.com.estudo.domain.PagamentoComBoleto;
import br.com.estudo.domain.PagamentoComCartao;
import br.com.estudo.domain.Pedido;
import br.com.estudo.domain.Produto;
import br.com.estudo.domain.enums.EstadoPagamento;
import br.com.estudo.domain.enums.TipoCliente;
import br.com.estudo.repositories.CategoriaRepository;
import br.com.estudo.repositories.CidadeRepository;
import br.com.estudo.repositories.ClienteRepository;
import br.com.estudo.repositories.EnderecoRepository;
import br.com.estudo.repositories.EstadoRepository;
import br.com.estudo.repositories.PagamentoRepository;
import br.com.estudo.repositories.PedidoRepository;
import br.com.estudo.repositories.ProdutoRepository;

@SpringBootApplication
public class EstudomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private	PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria objCategoria1 = new Categoria(null, "Informática");
		Categoria objCategoria2 = new Categoria(null, "Escritório");
		
		Produto objProduto1 = new Produto(null, "Computador", 2000.00);
		Produto objProduto2 = new Produto(null, "Impressora", 800.00);
		Produto objProduto3 = new Produto(null, "Mouse", 80.00);
		
		objCategoria1.getProdutos().addAll(Arrays.asList(objProduto1, objProduto2, objProduto3));
		objCategoria2.getProdutos().addAll(Arrays.asList(objProduto2));
		
		objProduto1.getCategorias().addAll(Arrays.asList(objCategoria1));
		objProduto2.getCategorias().addAll(Arrays.asList(objCategoria1, objCategoria2));
		objProduto3.getCategorias().addAll(Arrays.asList(objCategoria1));
		
		categoriaRepository.saveAll(Arrays.asList(objCategoria1, objCategoria2));
		produtoRepository.saveAll(Arrays.asList(objProduto1, objProduto2, objProduto3));
		
		Estado objEstado1 = new Estado(null, "Minas Gerais");
		Estado objEstado2 = new Estado(null, "São Paulo");
		
		Cidade objCidade1 = new Cidade(null, "Uberlândia", objEstado1);
		Cidade objCidade2 = new Cidade(null, "São Paulo", objEstado2);
		Cidade objCidade3 = new Cidade(null, "Campinas", objEstado2);
		
		objEstado1.getCidades().addAll(Arrays.asList(objCidade1));
		objEstado2.getCidades().addAll(Arrays.asList(objCidade2, objCidade3));
		
		estadoRepository.saveAll(Arrays.asList(objEstado1, objEstado2));
		cidadeRepository.saveAll(Arrays.asList(objCidade1, objCidade2, objCidade3));
		
		Cliente objCliente1 = new Cliente(null, "Sergio Ovalle", "sergioomarcelo@gmail.com", "435.912.038-90", TipoCliente.PESSOAFISICA);
		objCliente1.getTelefones().addAll(Arrays.asList("99688-0666", "3603-4715"));
		
		Endereco objEndereco1 = new Endereco(null, "Rua Sergio", "1", "Apto:1", "Remédios", "05102-090", objCliente1, objCidade1);
		Endereco objEndereco2 = new Endereco(null, "Rua Ovalle", "2", "Apto:2", "Remédios", "05102-090", objCliente1, objCidade2);
		
		objCliente1.getEnderecos().addAll(Arrays.asList(objEndereco1, objEndereco2));
		
		clienteRepository.saveAll(Arrays.asList(objCliente1));
		enderecoRepository.saveAll(Arrays.asList(objEndereco1, objEndereco2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido objPedido1 = new Pedido(null, sdf.parse("16/10/1999 10:3"), objCliente1, objEndereco1);
		Pedido objPedido2 = new Pedido(null, sdf.parse("17/11/2000 10:3"), objCliente1, objEndereco2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, objPedido1, 6);
		objPedido1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, objPedido2, sdf.parse("20/10/2017 10:3"), null);
		objPedido2.setPagamento(pagto2);
		
		objCliente1.getPedidos().addAll(Arrays.asList(objPedido1, objPedido2));
		
		pedidoRepository.saveAll(Arrays.asList(objPedido1, objPedido2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}
