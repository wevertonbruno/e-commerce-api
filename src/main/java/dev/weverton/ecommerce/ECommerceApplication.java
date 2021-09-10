package dev.weverton.ecommerce;

import java.util.Arrays;
import java.util.List;

import dev.weverton.ecommerce.domain.*;
import dev.weverton.ecommerce.domain.enums.TipoCliente;
import dev.weverton.ecommerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informatica");
		Categoria c2 = new Categoria(null, "Eletrodomesticos");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade ci1 = new Cidade(null, "Uberlândia", e1);
		Cidade ci2 = new Cidade(null, "São Paulo", e2);
		Cidade ci3 = new Cidade(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(ci1));
		e2.getCidades().addAll(Arrays.asList(ci2, ci3));

		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));

		Cliente cliente1 = new Cliente(null, "Weverton Bruno",
				"wevertonbrunera@gmail.com", "04127867531", TipoCliente.PESSOA_FISICA);

		cliente1.getTelefones().addAll(Arrays.asList("999999999", "888888888"));

		Endereco end1 = new Endereco(null, "Manoel Clementino", "1500",
				"Apto 102", "Centro", "48904453", cliente1, ci1);

		Endereco end2 = new Endereco(null, "Manoel Clementino 2", "1500",
				"Apto 103", "Centro", "48904454", cliente1, ci2);

		cliente1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.save(cliente1);
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
	}

}
