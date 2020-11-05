package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.CoordenadorController;
import br.edu.ifpb.fcgp.academico.model.Coordenador;

@Named(value = "consCooderBean")
@ViewScoped
public class ConsultaCoordenadorBean extends GenericAcademicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private List<Coordenador> coordenador;
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private Integer id;
	
	@Inject 
	private CoordenadorController controller;
	
	public void init() {
		if (id == null) {
			coordenador = controller.findAll();
		}else {
			coordenador = Collections.singletonList(controller.find(id));
		}
	}
	public String excluir(Coordenador coordenador) {
		controller.excluir(coordenador);
		this.addInfoMessage("Coodernador excluído com sucesso!");
		this.init();
		return null;
		
	}
	public String editar(Coordenador coordenador) {
		this.putFlash("coodernador",coordenador);
		return "cadastroCood?faces-redirect=true";
	}
	public String excluirSelecionados() {
		Coordenador cod = null;
		for (Integer id : checked.keySet()) {
			if (checked.get(id)) {
				cod = controller.find(id);
				controller.excluir(cod);
			}
		}
		coordenador = controller.findAll();
		checked.clear();
		this.addInfoMessage("Coodernador selecionados excluídos com sucesso!");
		return null;
	}
	public List<Coordenador> getCoodernador() {
		return coordenador;
	}
	public void setCoodernador(List<Coordenador> coordenador) {
		this.coordenador = coordenador;
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
