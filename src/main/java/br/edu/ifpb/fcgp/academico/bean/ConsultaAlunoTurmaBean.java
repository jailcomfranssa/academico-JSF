package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.UsuarioTurmaController;
import br.edu.ifpb.fcgp.academico.model.UsuarioTurma;

@Named(value = "consAluTurmaBean")
@ViewScoped
public class ConsultaAlunoTurmaBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<UsuarioTurma> usuarioturma;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private UsuarioTurmaController controller;
	
	public void init() {
		if (id == null) {
			usuarioturma = controller.findAluno();
		}else {
			usuarioturma = Collections.singletonList(controller.find(id));
		}
	}
	
	public void initP() {
		if (id == null) {
			usuarioturma = controller.findProf();
		}else {
			usuarioturma = Collections.singletonList(controller.find(id));
		}
	}
	public String excluir(UsuarioTurma usuarioturma) {
		controller.excluir(usuarioturma);
		this.addInfoMessage(" excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(UsuarioTurma usuarioturma) {
		this.putFlash("usuarioTurma",usuarioturma);
		return "cadastro?faces-redirect=true";
	}
	public String excluirSelecionados() {
		UsuarioTurma cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		usuarioturma = controller.findAll();
		checked.clear();
		this.addInfoMessage("Coodernador selecionados excluídos com sucesso!");
		return null;
	}

	public List<UsuarioTurma> getUsuarioturma() {
		return usuarioturma;
	}

	public void setUsuarioturma(List<UsuarioTurma> usuarioturma) {
		this.usuarioturma = usuarioturma;
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
