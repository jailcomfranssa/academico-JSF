package br.edu.ifpb.fcgp.academico.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //chave sintética da entidade
	
	private String nome;
	private String codigo;
	private String curso;
	private Integer tempo;
	
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;
	
	@OneToMany(mappedBy="disciplina")
	private List<Aula> aula;
	
	@OneToMany(mappedBy="disciplina")
	private List<Nota> nota;
	
	
	
	
	
	
	public Disciplina () {
		
	}


	public Disciplina(Integer id, String nome, String codigo, String curso, Integer tempo, Turma turma, List<Aula> aula, List<Nota> nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.curso = curso;
		this.tempo = tempo;
		this.turma = turma;
		this.aula = aula;
		this.nota = nota;
		
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public Integer getTempo() {
		return tempo;
	}


	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

	public List<Aula> getAula() {
		return aula;
	}


	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}
	
	


	public List<Nota> getNota() {
		return nota;
	}


	public void setNota(List<Nota> nota) {
		this.nota = nota;
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", curso=" + curso + ", tempo="
				+ tempo + ", turma=" + turma + ", aula=" + aula + ", nota=" + nota + "]";
	}


	


	

	


	


	
	
	

}
