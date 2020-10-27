package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.AlunoController;
import br.edu.ifpb.fcgp.academico.model.Aluno;

@Named(value = "consAlunoBean")
@ViewScoped
public class ConsultaAlunoBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Aluno> alunos;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private AlunoController controller;

	
	public void init() {
		if (id == null) {
			alunos = controller.findAll();
		} else {
			alunos = Collections.singletonList(controller.find(id));
		}
	}

	public String excluir(Aluno aluno) {
		controller.excluir(aluno);
		this.addInfoMessage("Aluno excluído com sucesso!");
		this.init();
		return null;
	}
	
	public String editar(Aluno aluno) {
		this.putFlash("aluno", aluno);
		return "cadastro?faces-redirect=true";
		
	}
	
	public void matriculado(Aluno aluno) {
		
	}
	
	public String excluirSelecionados() {
		Aluno a = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				a = controller.find(id);
				controller.excluir(a);
			}
		}
		alunos = controller.findAll();
		checked.clear();
		this.addInfoMessage("Alunos selecionados excluídos com sucesso!");
		return null;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
