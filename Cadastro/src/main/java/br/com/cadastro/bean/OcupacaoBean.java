package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cadastro.dao.OcupacaoDao;
import br.com.cadastro.modelo.Ocupacao;

@ManagedBean
@RequestScoped
public class OcupacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ocupacao ocupacao = new Ocupacao();
	
	private OcupacaoDao dao = new OcupacaoDao();
	
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
		if(ocupacao.getId()==null) {
			dao.adicionar(ocupacao);
			
		}else {
			dao.atualiza(ocupacao);
			
		}
		
		this.ocupacao = new Ocupacao();
	}

	public List<Ocupacao> getLista(){
		List<Ocupacao> ocupacoes = dao.listaTodos();
		return ocupacoes;
	}
	
	
	public void remover(Ocupacao ocupacao) {
		try {
			dao.remover(ocupacao);
			
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
