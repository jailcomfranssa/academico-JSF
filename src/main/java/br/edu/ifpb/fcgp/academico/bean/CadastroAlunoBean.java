package br.edu.ifpb.fcgp.academico.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.fcgp.academico.controller.AlunoController;
import br.edu.ifpb.fcgp.academico.controller.CursoController;
import br.edu.ifpb.fcgp.academico.model.Aluno;
import br.edu.ifpb.fcgp.academico.model.Curso;

@Named(value = "cadAlunoBean")
@ViewScoped
public class CadastroAlunoBean extends GenericAcademicoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Aluno aluno;
	
	@Inject
	private AlunoController controllerAluno;

	@Inject
	private CursoController controllerCurso;
	
	@PostConstruct
	public void init() {
		Aluno alunoFlash = (Aluno) this.getFlash("aluno");
		if (alunoFlash != null) {
			this.aluno = alunoFlash;
		}
	}
	
	public String cadastrar() {
		// Usa o dao para inserir o aluno
		Integer id = aluno.getId();
		controllerAluno.saveOrUpdate(aluno);
		
		this.keepMessages();
		if (id == null) {
			this.addInfoMessage("Aluno cadatrado com sucesso!");
		} else {
			this.addInfoMessage("Aluno atualizado com sucesso!");
		}
		
		// Limpa objeto do formulário
		aluno = new Aluno();
		
		// Retorna para mesma página
		return "consulta?faces-redirect=true";
	}

	public List<Curso> getCursoItems() {
		List<Curso> cursos = controllerCurso.findAll();
		return cursos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
