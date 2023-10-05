package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import br.com.cadastro.dao.BeneficiosDao;
import br.com.cadastro.modelo.Beneficio;

@ManagedBean
@RequestScoped
public class BeneficiosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	BeneficiosDao beneficioDao = new BeneficiosDao();
	
	private Beneficio beneficio = new Beneficio();
	@SuppressWarnings("unused")
	private List<Beneficio> beneficios;
	
	
	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public String formBeneficios() {
		return "formBeneficios?faces-redirect=true";

	}
	@Transactional
	public void gravar() {
		
		
		if(beneficio.getId() == null) {
			System.out.println("gravando");
			beneficioDao.adicionar(beneficio);
				
		}else {
			System.out.println("atualizando");
			beneficioDao.atualiza(beneficio);
		}
		
		this.beneficio = new Beneficio();

	}
	public List<Beneficio> getBeneficios(){
		List<Beneficio> beneficios = beneficioDao.listaTodos();
		return beneficios;
	}
	
	public void remover(Beneficio beneficio) {
		try {
			beneficioDao.remover(beneficio);
		} catch (Exception e) {
			e.getMessage();
			FacesContext.getCurrentInstance().addMessage("beneficio",
					new FacesMessage("Beneficio em uso, não é possivel remover!"));
			return;
		}
	}
	
	
	public void carregar(Beneficio beneficio){
		
		this.beneficio = beneficio;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}
	
	

	
	

}
