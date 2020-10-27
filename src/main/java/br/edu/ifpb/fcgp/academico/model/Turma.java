package br.edu.ifpb.fcgp.academico.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_TURMA")
public class Turma implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private Integer id;
			
			private String codigo;
			
			@OneToMany(mappedBy="turma")
			private List<UsuarioTurma> usuarioTurma;
			
			@OneToMany(mappedBy="turma")
			private List<Disciplina> disciplina;
			
			public Turma() {}

			public Turma(Integer id, String codigo, List<UsuarioTurma> usuarioTurma, List<Disciplina> disciplina) {
				super();
				this.id = id;
				this.codigo = codigo;
				this.usuarioTurma = usuarioTurma;
				this.disciplina = disciplina;
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getCodigo() {
				return codigo;
			}

			public void setCodigo(String codigo) {
				this.codigo = codigo;
			}

			public List<UsuarioTurma> getUsuarioTurma() {
				return usuarioTurma;
			}

			public void setUsuarioTurma(List<UsuarioTurma> usuarioTurma) {
				this.usuarioTurma = usuarioTurma;
			}
			
			

			public List<Disciplina> getDisciplina() {
				return disciplina;
			}

			public void setDisciplina(List<Disciplina> disciplina) {
				this.disciplina = disciplina;
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
				Turma other = (Turma) obj;
				if (id == null) {
					if (other.id != null)
						return false;
				} else if (!id.equals(other.id))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "Turma [id=" + id + ", codigo=" + codigo + ", usuarioTurma=" + usuarioTurma + ", disciplina="
						+ disciplina + "]";
			}

			
			
			

}
