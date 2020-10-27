package br.edu.ifpb.fcgp.academico.controller;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.fcgp.academico.dao.Transactional;
import br.edu.ifpb.fcgp.academico.dao.UsuarioTurmaDAO;
import br.edu.ifpb.fcgp.academico.model.UsuarioTurma;

public class UsuarioTurmaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioTurmaDAO usuarioTurmaDAO;
	
	@Transactional
	public void excluir(UsuarioTurma usuarioTurma) {
		usuarioTurmaDAO.delete(usuarioTurma);
	}
	
	@Transactional
	public UsuarioTurma update(UsuarioTurma usuarioTurma) {
		return usuarioTurmaDAO.update(usuarioTurma);
	}
	
	public void refresh(UsuarioTurma usuarioTurma) {
		usuarioTurmaDAO.refresh(usuarioTurma);
	}
	
	public List<UsuarioTurma> findAll() {
		return usuarioTurmaDAO.findAll();
	}
	
	public List<UsuarioTurma> findAluno() {
		return usuarioTurmaDAO.getAluno();
	}
	
	public List<UsuarioTurma> findProf() {
		return usuarioTurmaDAO.getProfessor();
	}
	public UsuarioTurma find(Integer id) {
		return usuarioTurmaDAO.find(id);
	}
	
	@Transactional
	public UsuarioTurma insert(UsuarioTurma usuarioTurma) {
		return usuarioTurmaDAO.insert(usuarioTurma);
	}
	
	@Transactional
	public void saveOrUpdate(UsuarioTurma usuarioTurma) {
		if (usuarioTurma.getId() != null) {
			usuarioTurma = usuarioTurmaDAO.update(usuarioTurma);
		} else {
			usuarioTurmaDAO.insert(usuarioTurma);
		}
		
	}

}
