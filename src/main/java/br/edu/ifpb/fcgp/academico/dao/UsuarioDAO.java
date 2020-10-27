package br.edu.ifpb.fcgp.academico.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ifpb.fcgp.academico.model.Usuario;

public class UsuarioDAO extends GenericDAO <Usuario, Integer>{
	private static final long serialVersionUID = 1L;
	
	//metodos especificos ***********
		//**********
		
		public List<Usuario> getAluno() {
		    String queryString = "SELECT a FROM Usuario a " +
		                         "WHERE a.tipo =('ALUNO') ";
		    TypedQuery<Usuario> typedQueryResultList =entityManager.createQuery(queryString, Usuario.class);
		    List<Usuario> usuario = typedQueryResultList.getResultList() ;
		    return usuario;
		}
		
		public List<Usuario> getProfessor() {
		    String queryString = "SELECT a FROM Usuario a " +
		                         "WHERE a.tipo =('PROFESSOR') ";
		    TypedQuery<Usuario> typedQueryResultList =entityManager.createQuery(queryString, Usuario.class);
		    List<Usuario> usuario = typedQueryResultList.getResultList() ;
		    return usuario;
		}

}
