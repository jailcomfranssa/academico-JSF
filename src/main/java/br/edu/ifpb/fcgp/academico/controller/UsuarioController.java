package br.edu.ifpb.fcgp.academico.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.fcgp.academico.dao.LoginDAO;
import br.edu.ifpb.fcgp.academico.dao.Transactional;
import br.edu.ifpb.fcgp.academico.dao.UsuarioDAO;
import br.edu.ifpb.fcgp.academico.model.Coordenador;
import br.edu.ifpb.fcgp.academico.model.Disciplina;
import br.edu.ifpb.fcgp.academico.model.Nota;
import br.edu.ifpb.fcgp.academico.model.Usuario;

public class UsuarioController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDAO usuarioDao;
	
	@Inject
	private LoginDAO loginDao;
	
	

	
	
	@Transactional
	public void excluir(Usuario usuario) {
		usuarioDao.delete(usuario);
		
	}
	
	@Transactional
	public Usuario update(Usuario usuario) {
		return usuarioDao.update(usuario);
	}
	
	public void refresh(Usuario usuario) {
		usuarioDao.refresh(usuario);
	}
	
	
	 public Usuario Login(String login, String senha) {
	  
	 return loginDao.getLogin(login,senha); }
	 
	 public Coordenador CoodAtivo(Integer id) {
		 return loginDao.getCoodAtivo(id);
		 
	 }
	 
	
	
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}
	public List<Usuario>findAluno(){
		return usuarioDao.getAluno();
	}
	public List<Usuario>findProf(){
		return usuarioDao.getProfessor();
	}
	
	public List<Nota>getNota(Integer id){
		return loginDao.getNota(id);
	}
	
	public List<Disciplina>getDiciplinaAluno(){
		return loginDao.getTurmaAluno();
	}
	
	
	public Usuario find(Integer id) {
		return usuarioDao.find(id);
	}
	@Transactional
	public Usuario insert(Usuario usuario) {
		return usuarioDao.insert(usuario);
	}
	@Transactional
	public void saveOrUpdate(Usuario usuario) {
		if (usuario.getId() != null) {
			usuario = usuarioDao.update(usuario);
		} else {
			usuarioDao.insert(usuario);
		}
		
	}

	

}
