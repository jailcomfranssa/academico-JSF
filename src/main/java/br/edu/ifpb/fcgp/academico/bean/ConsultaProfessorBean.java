package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.UsuarioController;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "consProfBean")
@ViewScoped
public class ConsultaProfessorBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuario;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject
	private UsuarioController controller;
	
	public void init() {
		if (id == null) {
			usuario = controller.findProf();
		} else {
			usuario = Collections.singletonList(controller.find(id));
		}
	}
	
	public String excluir(Usuario user) {
		controller.excluir(user);
		this.addInfoMessage("Professor excluído com sucesso!");
		this.init();
		return null;
	}
	public String editar(Usuario user) {
		this.putFlash("usuario", user);
		return "cadastro?faces-redirect=true";
		
	}
	public String excluirSelecionados() {
		Usuario user = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				user = controller.find(id);
				controller.excluir(user);
			}
		}
		usuario = controller.findProf();
		checked.clear();
		this.addInfoMessage("Professor selecionados excluídos com sucesso!");
		return null;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
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
