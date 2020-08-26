package com.marcelocosta.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelocosta.cursomc.domain.Categoria;
import com.marcelocosta.cursomc.domain.Cidade;
import com.marcelocosta.cursomc.domain.Cliente;
import com.marcelocosta.cursomc.domain.Endereco;
import com.marcelocosta.cursomc.domain.Estado;
import com.marcelocosta.cursomc.domain.Produto;
import com.marcelocosta.cursomc.domain.enums.TipoCliente;
import com.marcelocosta.cursomc.repositories.CategoriaRepository;
import com.marcelocosta.cursomc.repositories.CidadeRepository;
import com.marcelocosta.cursomc.repositories.ClienteRepository;
import com.marcelocosta.cursomc.repositories.EnderecoRepository;
import com.marcelocosta.cursomc.repositories.EstadoRepository;
import com.marcelocosta.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository   produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Paulista", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Recife", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1,c3));
		est2.getCidades().addAll(Arrays.asList(c2));		
			
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "77424733419", TipoCliente.PESSOA_FISICA );
		
		cli1.getTelefones().addAll(Arrays.asList("986751234", "985341212"));
		
		Endereco e1 = new Endereco(null, "R. flores", "300", "Apto 303", "Jardim", "23488484", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Mattos", "56", "Sala 07", "Centro", "3455353", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
