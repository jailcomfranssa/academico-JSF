package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.CoordenadorController;
import br.edu.ifpb.fcgp.academico.controller.UsuarioController;

import br.edu.ifpb.fcgp.academico.model.Coordenador;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "cadCoodBean")
@ViewScoped
public class CadastroCoordenadorBean  extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Coordenador coordenador;
	
	@Inject
	private CoordenadorController codController;
	
	@Inject
	private UsuarioController userController;
	
	@PostConstruct
	public void init() {
		Coordenador codFlash = (Coordenador) this.getFlash("coodernador");
		if (codFlash != null) {
			this.coordenador = codFlash;
		}
	}
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = coordenador.getId();
		codController.saveOrUpdate(coordenador);
		
		
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Coodernador cadatrado com sucesso!");
		} else {
			this.addInfoMessage("Coodernador atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		coordenador = new Coordenador();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}
	
	public List<Usuario> getUsuarioItems() {
		List<Usuario> user = userController.findProf();
		return user;
	}
	public Coordenador getCoodernador() {
		return coordenador;
	}
	public void setCoodernador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
	
	
	
	
	
	

}
