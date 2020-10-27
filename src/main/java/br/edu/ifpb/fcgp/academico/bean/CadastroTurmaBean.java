package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.TurmaController;
import br.edu.ifpb.fcgp.academico.model.Turma;

@Named(value = "cadTurmaBean")
@ViewScoped
public class CadastroTurmaBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Turma turma;
	
	@Inject
	private TurmaController controller;
	
	
	@PostConstruct
	public void init() {
		Turma turmaFlash = (Turma) this.getFlash("turma");
		if (turmaFlash != null) {
			this.turma = turmaFlash;
		}
	}
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = turma.getId();
		controller.saveOrUpdate(turma);
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Turma cadatrado com sucesso!");
		} else {
			this.addInfoMessage("Turma atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		turma = new Turma();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	


}
