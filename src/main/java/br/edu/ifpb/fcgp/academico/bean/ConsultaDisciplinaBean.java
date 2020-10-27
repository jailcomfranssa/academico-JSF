package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.DisciplinaController;
import br.edu.ifpb.fcgp.academico.model.Disciplina;

@Named(value = "consDisciplinaBean")
@ViewScoped
public class ConsultaDisciplinaBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Disciplina>disciplina;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private DisciplinaController controller;
	
	public void init() {
		if (id == null) {
			disciplina = controller.findAll();
		}else {
			disciplina = Collections.singletonList(controller.find(id));
		}
	}
	
	public String excluir(Disciplina disciplina) {
		controller.excluir(disciplina);
		this.addInfoMessage(" excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(Disciplina disciplina) {
		this.putFlash("disciplina",disciplina);
		return "cadastro?faces-redirect=true";
	}
	
	public String excluirSelecionados() {
		Disciplina cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		disciplina = controller.findAll();
		checked.clear();
		this.addInfoMessage("Disciplina selecionados excluídos com sucesso!");
		return null;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
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
