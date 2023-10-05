package br.com.cadastro.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Beneficio;

public class BeneficiosDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	public BeneficiosDao() {
		em = JPAUtil.getEntityManager();
	}

		
	
	public void adicionar(Beneficio beneficio) {
		
		beneficio.setId(null);
		em.getTransaction().begin();
		em.persist(beneficio);
		em.getTransaction().commit();
		em.close();

	}

	public void remover(Beneficio beneficio) {
		em.getTransaction().begin();
		em.remove(em.merge(beneficio));
		em.getTransaction().commit();
		em.close();
	}

	public void atualiza(Beneficio beneficio) {
		em.getTransaction().begin();
		em.merge(beneficio);
		em.getTransaction().commit();
		em.close();
	}

	public List<Beneficio> listaTodos() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		List<Beneficio> beneficios = em.createQuery("from Beneficio ", Beneficio.class).getResultList();
		em.close();
		return beneficios;

	}

	public Beneficio getBeneficioID(Integer id) {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		Beneficio beneficioId = em.find(Beneficio.class, id);
		em.close();
		return beneficioId;

	}

}