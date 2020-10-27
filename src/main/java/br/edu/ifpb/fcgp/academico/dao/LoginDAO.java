package br.edu.ifpb.fcgp.academico.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ifpb.fcgp.academico.model.Coodernador;
import br.edu.ifpb.fcgp.academico.model.Disciplina;
import br.edu.ifpb.fcgp.academico.model.Nota;
import br.edu.ifpb.fcgp.academico.model.Usuario;

public class LoginDAO extends GenericDAO <Usuario, Integer>{
	private static final long serialVersionUID = 1L;
	
	public List<Usuario> getuser() {
	    String queryString = "SELECT a FROM Usuario a ";
	    TypedQuery<Usuario> typedQueryResultList =entityManager.createQuery(queryString, Usuario.class);
	    List<Usuario> usuario = typedQueryResultList.getResultList() ;
	    return usuario;
	}
	
	public Usuario getLogin(String login, String senha) {
		try {
			String queryString = "SELECT u FROM Usuario u WHERE u.login =?1 and u.senha=?2 ";
			   
		    TypedQuery<Usuario> typedQuery =entityManager.createQuery(queryString, Usuario.class);
		    typedQuery.setParameter(1, login);
		    typedQuery.setParameter(2, senha);
		    Usuario usuario = typedQuery.getSingleResult();
		    return usuario;
			
			
		} catch (Exception e) {
			return null;
		}
	    
	    
	}
	
	public Coodernador getCoodAtivo(Integer id) {
		try {
		    String query = "SELECT u FROM Coodernador u WHERE u.usuario.id =?1 ";
		    TypedQuery<Coodernador> typedQuery =entityManager.createQuery(query, Coodernador.class);
		    typedQuery.setParameter(1, id);
		    Coodernador coode = typedQuery.getSingleResult();
		    return coode;
		    
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Nota> getNota(Integer id) {
		try {
			
			String query = "SELECT n FROM Nota n WHERE n.usuario.id =?1 ";
			TypedQuery<Nota> typedQueryResultList =entityManager.createQuery(query, Nota.class);
			typedQueryResultList.setParameter(1, id);
			List<Nota> usuarioNota =  typedQueryResultList.getResultList() ;
			 return usuarioNota;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Disciplina> getTurmaAluno() {
			
			String queryString = "SELECT d FROM Disciplina  d  " +
									"join Turma t on d.turma.id = d.id"
									
									;
									
									
						TypedQuery<Disciplina> typedQueryResultList =entityManager.createQuery(queryString, Disciplina.class);
						List<Disciplina> usuario = typedQueryResultList.getResultList() ;
						return usuario;
		}
		
	

}























































