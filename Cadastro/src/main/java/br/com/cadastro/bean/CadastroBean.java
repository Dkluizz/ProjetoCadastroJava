package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.cadastro.dao.BeneficiosDao;
import br.com.cadastro.dao.CadastroDao;
import br.com.cadastro.dao.OcupacaoDao;
import br.com.cadastro.enum1.Formacao;
import br.com.cadastro.enum1.Genero;
import br.com.cadastro.enum1.Nacionalidade;
import br.com.cadastro.enum1.TipoEndereco;
import br.com.cadastro.enum1.TipoTelefone;
import br.com.cadastro.modelo.Beneficio;
import br.com.cadastro.modelo.Cadastro;
import br.com.cadastro.modelo.Contato;
import br.com.cadastro.modelo.Ocupacao;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cadastro pessoa = new Cadastro();

	private List<Cadastro> cadastros;

	private List<Beneficio> beneficioSel = new ArrayList<Beneficio>();

	private Contato contato = new Contato();
	private List<Contato> listaContatos = new ArrayList<Contato>();

	private Ocupacao ocupacao = new Ocupacao();

	private Integer cadId;
	private Boolean eEditavel = false;

	// GETTERS e SETTERS

	public Boolean geteEditavel() {
		return eEditavel;
	}

	public void seteEditavel(Boolean eEditavel) {
		this.eEditavel = eEditavel;
	}

	public List<Beneficio> getBeneficioSel() {
		return beneficioSel;
	}

	public void setBeneficioSel(List<Beneficio> beneficioSel) {
		this.beneficioSel = beneficioSel;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Ocupacao getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Ocupacao ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Cadastro getPessoa() {
		return pessoa;
	}

	public void setPessoa(Cadastro pessoa) {
		this.pessoa = pessoa;
	}

	public void setCadId(Integer cadId) {
		this.cadId = cadId;
	}

	public Integer getCadId() {
		return cadId;
	}

	// FIM GETTERS e SETTERS

	// ENUMS

	public Genero[] getGeneros() {
		return Genero.values();
	}

	public Formacao[] getFormacao() {
		return Formacao.values();
	}

	public TipoEndereco[] getTipoEnd() {
		return TipoEndereco.values();
	}

	public Nacionalidade[] getNacionalidades() {
		return Nacionalidade.values();
	}

	public TipoTelefone[] getContatos() {
		return TipoTelefone.values();
	}
	// FIM ENUMS

	public String inicio() {
		return "index?faces-redirect=true";
	}

	// METODOS

	public void gravar() {
		CadastroDao cad = new CadastroDao();

		if (this.pessoa.getId() == null) {
			// Verifica Ocupacao
			if (ocupacao != null) {
				ocupacao.setId(Integer.valueOf(ocupacao.getOcupacao()));
			} else {
				FacesContext.getCurrentInstance().addMessage("cadastro",
						new FacesMessage("Não possui ocupação selecionada"));
				return;
			}
			pessoa.setOcupacao(ocupacao);

			// Verifica Beneficio
			
			pessoa.setBeneficios(beneficioSel);
			
			
			// Verifica Contato
			if (pessoa.getContato() == null) {
				FacesContext.getCurrentInstance().addMessage("contatos",
						new FacesMessage("Não possui contato cadastrado"));
				return;
			}

			cad.adicionar(pessoa);
			this.cadastros = cad.listaTodos();

		} else {

			if (ocupacao != null && ocupacao.getOcupacao() != "") {
				ocupacao.setId(Integer.valueOf(ocupacao.getOcupacao()));
			} else {
				FacesContext.getCurrentInstance().addMessage("cadastro",
						new FacesMessage("Não possui ocupação selecionada"));
				return;
			}
			pessoa.setOcupacao(ocupacao);
			pessoa.setBeneficios(beneficioSel);
			cad.atualiza(pessoa);
		}

		this.pessoa = new Cadastro();
		this.ocupacao = new Ocupacao();
		this.contato = new Contato();

	}

	public void ativaCampos() {
		eEditavel = false;

	}

	public void carregarCadastro(Cadastro cadastro) {
		this.pessoa = cadastro;
		this.ocupacao.setOcupacao(pessoa.getOcupacao().getId().toString());
		System.out.println(cadastro.getOcupacao().getId());
		eEditavel = true;
	}

	public void removerCadastro(Cadastro cadastro) {
		CadastroDao cadDao = new CadastroDao();
		cadDao.remover(cadastro);
		cadastros.remove(cadastro);
	}

	public void gravarContato() {

		if (pessoa.getContato() != null) {
			this.pessoa.adicionarContato(contato);
		} else {
			pessoa.setContato(listaContatos);
			this.pessoa.adicionarContato(contato);
		}
		contato = new Contato();
	}

	public void removerContato(Contato contato) {
		this.pessoa.removerContato(contato);
	}
	// FIM METODOS

	// LISTAGEM
	public List<Cadastro> getlista() {
		CadastroDao cad = new CadastroDao();

		if (this.cadastros == null) {
			cadastros = cad.listaTodos();
		}
		return cadastros;

	}

	public List<Beneficio> getlistaBeneficio() {
		BeneficiosDao cad = new BeneficiosDao();
		List<Beneficio> beneficios = cad.listaTodos();

		return beneficios;

	}

	public List<Ocupacao> getlistaOcupacao() {
		OcupacaoDao cad = new OcupacaoDao();
		List<Ocupacao> ocupacoes = cad.listaTodos();

		return ocupacoes;

	}

}
