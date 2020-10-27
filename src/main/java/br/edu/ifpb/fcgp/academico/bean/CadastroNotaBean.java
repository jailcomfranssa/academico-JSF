package br.edu.ifpb.fcgp.academico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.DisciplinaController;
import br.edu.ifpb.fcgp.academico.controller.NotaController;
import br.edu.ifpb.fcgp.academico.controller.UsuarioController;
import br.edu.ifpb.fcgp.academico.model.Disciplina;
import br.edu.ifpb.fcgp.academico.model.Nota;
import br.edu.ifpb.fcgp.academico.model.Usuario;

@Named(value = "cadNotaBean")
@ViewScoped
public class CadastroNotaBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Nota nota;
	
	@Inject
	private NotaController notaController;
	
	@Inject
	private UsuarioController userController;
	
	@Inject
	private DisciplinaController disController;
	
	@PostConstruct
	public void init() {
		Nota codFlash = (Nota) this.getFlash("nota");
		if (codFlash != null) {
			this.nota = codFlash;
		}
	}
	public String cadastrar() {
		Integer id = nota.getId();
		notaController.saveOrUpdate(nota);
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage(" cadatrado com sucesso!");
		}else {
			this.addInfoMessage(" atualizado com sucesso!");
		}
		
			nota = new Nota();
		
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
	public List<Disciplina> getDisciplinaItems() {
		List<Disciplina> user = disController.findAll();
		return user;
	}
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	

}
