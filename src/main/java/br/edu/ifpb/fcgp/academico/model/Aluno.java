package br.edu.ifpb.fcgp.academico.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_aluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //chave sintética da entidade
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name = "nu_matricula")
	private Integer matricula;
	
	@OneToMany (mappedBy = "aluno")
	private List<MatriculaCurso> cursos;
	
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	public Aluno() {
		// Para ser um JavaBean
	}
	
	public Aluno(String nome, Integer matricula, String curso, Date dataNascimento) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", dataNascimento="
				+ dataNascimento + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<MatriculaCurso> getCursos() {
		return cursos;
	}

	public void setCursos(List<MatriculaCurso> cursos) {
		this.cursos = cursos;
	}


	
}

