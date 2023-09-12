package br.com.cadastro.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.dao.JPAUtil;
import br.com.cadastro.enum1.Formacao;
import br.com.cadastro.enum1.Genero;
import br.com.cadastro.enum1.Nacionalidade;
import br.com.cadastro.enum1.TipoEndereco;
import br.com.cadastro.enum1.TipoTelefone;
import br.com.cadastro.modelo.Beneficio;
import br.com.cadastro.modelo.Cadastro;
import br.com.cadastro.modelo.Contato;
import br.com.cadastro.modelo.Ocupacao;

public class PopulaBanco {
	public static void main(String[] args) {

		Cadastro cadPessoal = new Cadastro();
		List <Cadastro> cadastros = new ArrayList<Cadastro>();

		Contato contato = new Contato();
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Ocupacao ocupacao = new Ocupacao();
		

		Beneficio beneficio = new Beneficio();
		List<Beneficio> beneficios = new ArrayList<Beneficio>();

		cadPessoal.setNome("Luiz Felipe");
		cadPessoal.setCpf("12053890673");
		cadPessoal.setRg("18414090");
		cadPessoal.setGenero(Genero.MASCULINO);
		cadPessoal.setNacionalidade(Nacionalidade.PARDO);
		cadPessoal.setFormacao(Formacao.ENS_SUPERIOR_COMPLETO);
		cadPessoal.setOcupacao(ocupacao);
	
		contato.setTipoTelefone(TipoTelefone.CELULAR);
		contato.setTelefone("38 999655170");
		contato.setEmail("luizmusician@gmail.com");
		contatos.add(contato);
		
		beneficio.setBeneficio("Vale Transporte");
		beneficio.setBeneficio("PLR");
		beneficio.setBeneficio("Vale Refeição");
		beneficio.setBeneficio("Bolsa Familia");
		beneficios.add(beneficio);
		
		ocupacao.setOcupacao("Programador");
		
		cadPessoal.setEndereco("D");
		cadPessoal.setBairro("Jardim Aeroporto");
		cadPessoal.setCidade("Bocaiuva");
		cadPessoal.setNumero("20");
		cadPessoal.setTipoEnd(TipoEndereco.RUA);
		cadPessoal.setEstado("MG");
		cadPessoal.setCep("39390000");
		cadastros.add(cadPessoal);
		
		cadPessoal.setOcupacao(ocupacao);
		cadPessoal.setBeneficios(beneficios);
		cadPessoal.setContato(contatos);
		
		
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(cadPessoal);
		em.persist(contato);
		em.persist(ocupacao);
		em.persist(beneficio);
		em.getTransaction().commit();
		em.close();

	}

}
