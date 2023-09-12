package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cadastro.dao.OcupacaoDao;
import br.com.cadastro.modelo.Ocupacao;

@ManagedBean
@ViewScoped
public class OcupacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ocupacao ocupacao = new Ocupacao();
	
	
	private List<Ocupacao> ocupacoes;
	

	public List<Ocupacao> getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(List<Ocupacao> ocupacoes) {
		this.ocupacoes = ocupacoes;
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String formOcupacao() {
		return "formOcupacao?faces-redirect=true";

	}

	public void gravar() {
		OcupacaoDao ocpDao = new OcupacaoDao();
		if(ocupacao.getId()==null) {
			ocpDao.adicionar(ocupacao);
			
			
		}else {
			ocpDao.atualiza(ocupacao);
			
		}
		
		this.ocupacao = new Ocupacao();
	}

	public List<Ocupacao> getLista(){
		OcupacaoDao ocpDao = new OcupacaoDao();
		List<Ocupacao> ocupacoes = ocpDao.listaTodos();
		return ocupacoes;
	}
	
	
	
	public void remover(Ocupacao ocupacao) {
		try {
			OcupacaoDao ocpDao = new OcupacaoDao();
			ocpDao.remover(ocupacao);
			
		} catch (Exception e) {
			e.getMessage();
			FacesContext.getCurrentInstance().addMessage("ocupacao",
					new FacesMessage("Ocupação em uso, não é possivel remover!"));
			return;
		}
		
	}
	
	public void carregar(Ocupacao ocupacao){
		this.ocupacao = ocupacao;
	}

}
