package br.com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.cadastro.modelo.Beneficio;

public class BeneficiosDao {

	private EntityManager em;

	public BeneficiosDao() {
		this.em = JPAUtil.getEntityManager();
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

		List<Beneficio> beneficios = em.createQuery("from Beneficio ", Beneficio.class).getResultList();

		em.close();
		return beneficios;

	}
	
	
	public Beneficio getBeneficioID(Integer id){
		Beneficio beneficioId = em.find(Beneficio.class, id);
		em.close();
		return beneficioId;
		
	}

}