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

@Entity
@Table(name="tb_curso")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //chave sintética da entidade
	
	@Column(name = "nm_nome")
	private String nome;
	
	@Column(name="nu_duracao")
	private Integer duracao;
	
	@Column(name="nm_coordenador")
	private String coordenador;
	
	@Column(name="dt_criacao")
	private Date dataCriacao;
	
	@OneToMany(mappedBy="curso")
	private List<MatriculaCurso> alunos;

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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<MatriculaCurso> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<MatriculaCurso> alunos) {
		this.alunos = alunos;
	}

	
}
