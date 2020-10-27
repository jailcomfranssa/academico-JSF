package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.DisciplinaController;
import br.edu.ifpb.fcgp.academico.controller.TurmaController;
import br.edu.ifpb.fcgp.academico.model.Disciplina;
import br.edu.ifpb.fcgp.academico.model.Turma;

@Named(value = "cadDisciplinaBean")
@ViewScoped
public class CadastroDisciplinaBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Disciplina disciplina;
	
	@Inject
	private DisciplinaController Controller;
	
	@Inject
	private TurmaController turmaController;
	
	
	@PostConstruct
	public void init() {
		Disciplina codFlash = (Disciplina) this.getFlash("disciplina");
		if (codFlash != null) {
			this.disciplina = codFlash;
		}
	}
	
	public String cadastrar() {
		Integer id = disciplina.getId();
		Controller.saveOrUpdate(disciplina);
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage(" cadatrado com sucesso!");
		}else {
			this.addInfoMessage(" atualizado com sucesso!");
		}
		
			disciplina = new Disciplina();
		
		// Retorna para mesma página
				return "consulta?faces-redirect=true";
	}
	public List<Turma> getTurmaItems() {
		List<Turma> user = turmaController.findAll();
		return user;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
