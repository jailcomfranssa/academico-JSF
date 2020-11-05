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
@Table(name="TB_USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;

		private String nome;
		private String email;
		private String matricula;
		private String login;
		private String senha;
		private String tipo;
		
		
		
		@OneToMany(mappedBy="usuario")
		private List<Coordenador> coordenador;
		
		
		
		@OneToMany(mappedBy="usuario")
		private List<UsuarioTurma> usuarioTurma;
		
		@OneToMany(mappedBy="usuario")
		private List<Nota> nota;
		
		
		
		public Usuario() {}

		public Usuario(int id, String nome, String email, String matricula, String login, String senha, String tipo, List<Coordenador> coordenador, List<UsuarioTurma>usuarioTurma, List<Nota> nota ) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.matricula = matricula;
			this.login = login;
			this.senha = senha;
			this.tipo = tipo;
			this.coordenador = coordenador;
			this.usuarioTurma = usuarioTurma;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		

		public List<Coordenador> getCoordenador() {
			return coordenador;
		}

		public void setCoordenador(List<Coordenador> coordenador) {
			this.coordenador = coordenador;
		}
		
		public List<UsuarioTurma> getUsuarioTurma() {
			return usuarioTurma;
		}

		public void setUsuarioTurma(List<UsuarioTurma> usuarioTurma) {
			this.usuarioTurma = usuarioTurma;
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
			result = prime * result + id;
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
			Usuario other = (Usuario) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", matricula=" + matricula + ", login="
					+ login + ", senha=" + senha + ", tipo=" + tipo + ", coordenador=" + coordenador + ", usuarioTurma="
					+ usuarioTurma + ", nota=" + nota + "]";
		}

		

		

		
		

}