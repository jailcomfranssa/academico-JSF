package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.UsuarioController;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "caduserBean")
@ViewScoped
public class CadastroUsuarioBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioController controller;
	
	
	@PostConstruct
	public void init() {
		Usuario usuarioFlash = (Usuario) this.getFlash("usuario");
		if (usuarioFlash != null) {
			this.usuario = usuarioFlash;
		}
	}
	
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = usuario.getId();
		controller.saveOrUpdate(usuario);
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("usuario cadatrado com sucesso!");
		} else {
			this.addInfoMessage("usuario atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		usuario = new Usuario();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}
	
	public List<String> getUsuarioTipo() {
		List<String> tipo = Arrays.asList(new String[] {
				"ALUNO", 
				"PROFESSOR"
				});
		return tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
