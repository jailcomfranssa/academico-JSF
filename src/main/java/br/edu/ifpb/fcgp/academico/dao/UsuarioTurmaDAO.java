package br.edu.ifpb.fcgp.academico.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ifpb.fcgp.academico.model.UsuarioTurma;

public class UsuarioTurmaDAO extends GenericDAO<UsuarioTurma, Integer>{
	private static final long serialVersionUID = 1L;
	
	public List<UsuarioTurma> getAluno() {
		
		String queryString = "SELECT a FROM UsuarioTurma  a  " +
								"WHERE a.usuario.tipo =('ALUNO') "; 
					TypedQuery<UsuarioTurma> typedQueryResultList =entityManager.createQuery(queryString, UsuarioTurma.class);
					List<UsuarioTurma> usuario = typedQueryResultList.getResultList() ;
					return usuario;
	}
	
	public List<UsuarioTurma> getProfessor() {
		
		String queryString = "SELECT a FROM UsuarioTurma  a  " +
								"WHERE a.usuario.tipo =('PROFESSOR') "; 
					TypedQuery<UsuarioTurma> typedQueryResultList =entityManager.createQuery(queryString, UsuarioTurma.class);
					List<UsuarioTurma> usuario = typedQueryResultList.getResultList() ;
					return usuario;
	}
	
	


}
