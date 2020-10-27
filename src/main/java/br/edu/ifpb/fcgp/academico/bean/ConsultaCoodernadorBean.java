package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.CoodernadorController;
import br.edu.ifpb.fcgp.academico.model.Coodernador;

@Named(value = "consCooderBean")
@ViewScoped
public class ConsultaCoodernadorBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private List<Coodernador> coodernador;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private CoodernadorController controller;
	
	public void init() {
		if (id == null) {
			coodernador = controller.findAll();
		}else {
			coodernador = Collections.singletonList(controller.find(id));
		}
	}
	public String excluir(Coodernador coodernador) {
		controller.excluir(coodernador);
		this.addInfoMessage("Coodernador excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(Coodernador coodernador) {
		this.putFlash("coodernador",coodernador);
		return "cadastroCood?faces-redirect=true";
	}
	public String excluirSelecionados() {
		Coodernador cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		coodernador = controller.findAll();
		checked.clear();
		this.addInfoMessage("Coodernador selecionados excluídos com sucesso!");
		return null;
	}
	public List<Coodernador> getCoodernador() {
		return coodernador;
	}
	public void setCoodernador(List<Coodernador> coodernador) {
		this.coodernador = coodernador;
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
