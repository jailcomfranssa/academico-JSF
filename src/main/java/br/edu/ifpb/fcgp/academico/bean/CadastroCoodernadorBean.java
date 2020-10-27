package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.CoodernadorController;
import br.edu.ifpb.fcgp.academico.controller.UsuarioController;

import br.edu.ifpb.fcgp.academico.model.Coodernador;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "cadCoodBean")
@ViewScoped
public class CadastroCoodernadorBean  extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Coodernador coodernador;
	
	@Inject
	private CoodernadorController codController;
	
	@Inject
	private UsuarioController userController;
	
	@PostConstruct
	public void init() {
		Coodernador codFlash = (Coodernador) this.getFlash("coodernador");
		if (codFlash != null) {
			this.coodernador = codFlash;
		}
	}
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = coodernador.getId();
		codController.saveOrUpdate(coodernador);
		
		
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Coodernador cadatrado com sucesso!");
		} else {
			this.addInfoMessage("Coodernador atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		coodernador = new Coodernador();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}
	
	public List<Usuario> getUsuarioItems() {
		List<Usuario> user = userController.findProf();
		return user;
	}
	public Coodernador getCoodernador() {
		return coodernador;
	}
	public void setCoodernador(Coodernador coodernador) {
		this.coodernador = coodernador;
	}
	
	
	
	
	
	

}
