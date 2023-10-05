package br.com.cadastro.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Ocupacao;

public class OcupacaoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	public OcupacaoDao() {
		em = JPAUtil.getEntityManager();
	}

	public void adicionar(Ocupacao ocupacao) {
		em.persist(ocupacao);

	}

	public void remover(Ocupacao ocupacao) {
		em.remove(em.merge(ocupacao));

	}

	public void atualiza(Ocupacao ocupacao) {
		em.merge(ocupacao);

	}

	public List<Ocupacao> listaTodos() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		List<Ocupacao> ocupacoes = em.createQuery("from Ocupacao ", Ocupacao.class).getResultList();
		em.close();
		return ocupacoes;

	}

	public Ocupacao getOcupacaoID(Integer id){
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		Ocupacao ocupacaoId = em.find(Ocupacao.class, id);
		em.close();
		return ocupacaoId;
		
	}
	

}