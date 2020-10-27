package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.TurmaController;
import br.edu.ifpb.fcgp.academico.controller.UsuarioController;
import br.edu.ifpb.fcgp.academico.controller.UsuarioTurmaController;
import br.edu.ifpb.fcgp.academico.model.Turma;
import br.edu.ifpb.fcgp.academico.model.Usuario;
import br.edu.ifpb.fcgp.academico.model.UsuarioTurma;

@Named(value = "cadUserTurmaBean")
@ViewScoped
public class CadastroUsuarioTurmaBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioTurma usuarioTurma;
	
	@Inject
	private UsuarioTurmaController usuarioTurmaController;
	
	@Inject
	private TurmaController turmaController;
	
	@Inject
	private UsuarioController userController;
	
	
	@PostConstruct
	public void init() {
		UsuarioTurma codFlash = (UsuarioTurma) this.getFlash("usuarioTurma");
		if (codFlash != null) {
			this.usuarioTurma = codFlash;
		}
	}
	
	public String cadastrar() {
		Integer id = usuarioTurma.getId();
		usuarioTurmaController.saveOrUpdate(usuarioTurma);
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage(" cadatrado com sucesso!");
		}else {
			this.addInfoMessage(" atualizado com sucesso!");
		}
		
			usuarioTurma = new UsuarioTurma();
		
		// Retorna para mesma página
				return "consulta?faces-redirect=true";
	}
	
	public List<Usuario> getAlunoItems() {
		List<Usuario> user = userController.findAluno();
		return user;
	}
	
	public List<Usuario> getProfessorItems() {
		List<Usuario> user = userController.findProf();
		return user;
	}
	
	public List<Turma> getTurmaItems() {
		List<Turma> user = turmaController.findAll();
		return user;
	}

	public UsuarioTurma getUsuarioTurma() {
		return usuarioTurma;
	}

	public void setUsuarioTurma(UsuarioTurma usuarioTurma) {
		this.usuarioTurma = usuarioTurma;
	}
	
	
	

}
