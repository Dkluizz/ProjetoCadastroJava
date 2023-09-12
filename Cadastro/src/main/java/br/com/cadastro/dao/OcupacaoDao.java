package br.com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Ocupacao;

public class OcupacaoDao {

	private EntityManager em;

	public OcupacaoDao() {
		this.em = JPAUtil.getEntityManager();
	}

	public void adicionar(Ocupacao ocupacao) {

		em.getTransaction().begin();

		em.persist(ocupacao);

		em.getTransaction().commit();

		em.close();

	}

	public void remover(Ocupacao ocupacao) {

		em.getTransaction().begin();

		em.remove(em.merge(ocupacao));

		em.getTransaction().commit();

		em.close();

	}

	public void atualiza(Ocupacao ocupacao) {

		em.getTransaction().begin();

		em.merge(ocupacao);

		em.getTransaction().commit();

		em.close();

	}

	public List<Ocupacao> listaTodos() {

		List<Ocupacao> ocupacoes = em.createQuery("from Ocupacao ", Ocupacao.class).getResultList();
		em.close();
		return ocupacoes;

	}

	public Ocupacao getOcupacaoID(Integer id){
		Ocupacao ocupacaoId = em.find(Ocupacao.class, id);
		em.close();
		return ocupacaoId;
		
	}
	

}