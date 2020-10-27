package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.NotaController;
import br.edu.ifpb.fcgp.academico.model.Nota;

@Named(value = "consNotaBean")
@ViewScoped
public class ConsultaNotaBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Nota>nota;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private NotaController controller;
	
	public void init() {
		if (id == null) {
			nota = controller.findAll();
		}else {
			nota = Collections.singletonList(controller.find(id));
		}
	}
	
	public String excluir(Nota nota) {
		controller.excluir(nota);
		this.addInfoMessage(" excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(Nota nota) {
		this.putFlash("nota",nota);
		return "cadastro?faces-redirect=true";
	}
	public String excluirSelecionados() {
		Nota cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		nota = controller.findAll();
		checked.clear();
		this.addInfoMessage(" selecionados excluídos com sucesso!");
		return null;
	}

	public List<Nota> getNota() {
		return nota;
	}

	public void setNota(List<Nota> nota) {
		this.nota = nota;
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
