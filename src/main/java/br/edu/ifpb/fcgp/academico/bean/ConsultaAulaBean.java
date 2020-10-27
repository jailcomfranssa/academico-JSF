package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.AulaController;
import br.edu.ifpb.fcgp.academico.model.Aula;

@Named(value = "consAulaBean")
@ViewScoped
public class ConsultaAulaBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Aula>aula;
	
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private AulaController controller;
	
	public void init() {
		if (id == null) {
			aula = controller.findAll();
		}else {
			aula = Collections.singletonList(controller.find(id));
		}
	}
	public String excluir(Aula aula) {
		controller.excluir(aula);
		this.addInfoMessage("aula excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(Aula aula) {
		this.putFlash("aula",aula);
		return "cadastro?faces-redirect=true";
	}
	public String excluirSelecionados() {
		Aula cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		aula = controller.findAll();
		checked.clear();
		this.addInfoMessage("aula selecionados excluídos com sucesso!");
		return null;
	}
	public List<Aula> getAula() {
		return aula;
	}
	public void setAula(List<Aula> aula) {
		this.aula = aula;
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
