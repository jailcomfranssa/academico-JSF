package br.edu.ifpb.fcgp.academico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_matricula")
public class MatriculaCurso {
	@Id
	@Column(name="nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //chave sintética da entidade
	
	@ManyToOne 
	@JoinColumn(name="id_aluno")
	private Aluno aluno;
	
	@ManyToOne 
	@JoinColumn(name="id_curso")
	private Aluno curso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getCurso() {
		return curso;
	}

	public void setCurso(Aluno curso) {
		this.curso = curso;
	}
	
	
	

}

