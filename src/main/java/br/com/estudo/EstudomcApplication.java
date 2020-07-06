package br.com.estudo;

import java.text.SimpleDateFormat;
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
import br.com.estudo.domain.ItemPedido;
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
import br.com.estudo.repositories.ItemPedidoRepository;
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
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria objCategoria1 = new Categoria(null, "Informática");
		Categoria objCategoria2 = new Categoria(null, "Escritório");
		Categoria objCategoria3 = new Categoria(null, "Cama mesa e banho");
		Categoria objCategoria4 = new Categoria(null, "Eletronicos");
		Categoria objCategoria5 = new Categoria(null, "Jardinagem");
		Categoria objCategoria6 = new Categoria(null, "Decorações");
		Categoria objCategoria7 = new Categoria(null, "Perfumaria");
		
		Produto objProduto1 = new Produto(null, "Computador", 2000.00);
		Produto objProduto2 = new Produto(null, "Impressora", 800.00);
		Produto objProduto3 = new Produto(null, "Mouse", 80.00);
		Produto objProduto4 = new Produto(null, "Mesa de Escritorio", 300.00);
		Produto objProduto5 = new Produto(null, "Toalha", 50.00);
		Produto objProduto6 = new Produto(null, "Colcha", 200.00);
		Produto objProduto7 = new Produto(null, "TV true color", 1200.00);
		Produto objProduto8 = new Produto(null, "Roçadeira", 800.00);
		Produto objProduto9 = new Produto(null, "Abajour", 100.00);
		Produto objProduto10 = new Produto(null, "Pendente", 180.00);
		Produto objProduto11 = new Produto(null, "Shampoo", 90.00);
		
		objCategoria1.getProdutos().addAll(Arrays.asList(objProduto1, objProduto2, objProduto3));
		objCategoria2.getProdutos().addAll(Arrays.asList(objProduto2, objProduto4));
		objCategoria3.getProdutos().addAll(Arrays.asList(objProduto5, objProduto6));
		objCategoria4.getProdutos().addAll(Arrays.asList(objProduto1, objProduto2, objProduto3, objProduto7));
		objCategoria5.getProdutos().addAll(Arrays.asList(objProduto8));
		objCategoria6.getProdutos().addAll(Arrays.asList(objProduto9, objProduto10));
		objCategoria7.getProdutos().addAll(Arrays.asList(objProduto11));
		
		objProduto1.getCategorias().addAll(Arrays.asList(objCategoria1, objCategoria4));
		objProduto2.getCategorias().addAll(Arrays.asList(objCategoria1, objCategoria2, objCategoria4));
		objProduto3.getCategorias().addAll(Arrays.asList(objCategoria1, objCategoria4));
		objProduto4.getCategorias().addAll(Arrays.asList(objCategoria2));
		objProduto5.getCategorias().addAll(Arrays.asList(objCategoria3));
		objProduto6.getCategorias().addAll(Arrays.asList(objCategoria3));
		objProduto7.getCategorias().addAll(Arrays.asList(objCategoria4));
		objProduto8.getCategorias().addAll(Arrays.asList(objCategoria5));
		objProduto9.getCategorias().addAll(Arrays.asList(objCategoria6));
		objProduto10.getCategorias().addAll(Arrays.asList(objCategoria6));
		objProduto11.getCategorias().addAll(Arrays.asList(objCategoria7));
		
		categoriaRepository.saveAll(Arrays.asList(objCategoria1, objCategoria2, objCategoria3, objCategoria4, objCategoria5, objCategoria6, objCategoria7));
		produtoRepository.saveAll(Arrays.asList(objProduto1, objProduto2, objProduto3, objProduto4, objProduto5, objProduto6, objProduto7, objProduto8, objProduto9, objProduto10, objProduto11));
		
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
		
		ItemPedido ip1 = new ItemPedido(objPedido1, objProduto1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(objPedido1, objProduto3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(objPedido2, objProduto2, 100.00, 1, 800.00);
		
		objPedido1.getItens().addAll(Arrays.asList(ip1, ip2));
		objPedido2.getItens().addAll(Arrays.asList(ip3));
		
		objProduto1.getItens().addAll(Arrays.asList(ip1));
		objProduto2.getItens().addAll(Arrays.asList(ip3));
		objProduto3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
