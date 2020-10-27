package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.TurmaController;
import br.edu.ifpb.fcgp.academico.model.Turma;

@Named(value = "consTurmaBean")
@ViewScoped
public class ConsultaTurmaBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	List<Turma>turma;
	
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private TurmaController controller;
	
	public void init() {
		if (id == null) {
			turma = controller.findAll();
		} else {
			turma = Collections.singletonList(controller.find(id));
		}
	}
	public String excluir(Turma turma) {
		controller.excluir(turma);
		this.addInfoMessage("Aluno excluído com sucesso!");
		this.init();
		return null;
	}
	public String editar(Turma turma) {
		this.putFlash("turma", turma);
		return "cadastro?faces-redirect=true";
		
	}
	public String excluirSelecionados() {
		Turma a = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				a = controller.find(id);
				controller.excluir(a);
			}
		}
		turma = controller.findAll();
		checked.clear();
		this.addInfoMessage("Alunos selecionados excluídos com sucesso!");
		return null;
	}
	public List<Turma> getTurma() {
		return turma;
	}
	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	public Map<Integer, Boolean> getChecked() {
		return checked;
	}
	public void setChecked(Map<Integer, Boolean> checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
