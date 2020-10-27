package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.AulaController;
import br.edu.ifpb.fcgp.academico.controller.DisciplinaController;
import br.edu.ifpb.fcgp.academico.model.Aula;
import br.edu.ifpb.fcgp.academico.model.Disciplina;

@Named(value = "cadAulaBean")
@ViewScoped
public class CadastroAulaBean  extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aula aula;
	
	@Inject
	private AulaController Controller;
	
	@Inject
	private DisciplinaController discControlle;
	
	@PostConstruct
	public void init() {
		Aula codFlash = (Aula) this.getFlash("aula");
		if (codFlash != null) {
			this.aula= codFlash;
		}
	}
	
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = aula.getId();
		Controller.saveOrUpdate(aula);
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("aula cadatrado com sucesso!");
		} else {
			this.addInfoMessage("aula atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		aula = new Aula();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}
	
	public List<Disciplina> getDisciplinaItems() {
		List<Disciplina> user = discControlle.findAll();
		return user;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}
	

}
